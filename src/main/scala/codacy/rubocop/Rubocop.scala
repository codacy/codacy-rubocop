package codacy.rubocop

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths, StandardOpenOption}

import codacy.dockerApi._
import codacy.dockerApi.utils.CommandRunner
import play.api.libs.json._

import scala.io.Source
import scala.util.{Failure, Properties, Success, Try}

object Rubocop extends Tool {

  override def apply(path: Path, conf: Option[Seq[PatternDef]], files: Option[Set[Path]])(implicit spec: Spec): Try[Iterable[Result]] = {
    val cmd = getCommandFor(path, conf, files, spec, resultFilePath)
    CommandRunner.exec(cmd, Some(path.toFile))
    val resultFromTool = getFileLines(resultFilePath.toFile)
    parseResult(resultFromTool)
  }

  private[this] def getFileLines(filename: File): String = {
    Source.fromFile(filename).getLines().mkString
  }

  private[this] def parseResult(resultFromTool: String): Try[Iterable[Result]] = {
    Try(Json.parse(resultFromTool)).flatMap { json =>
      json.validate[RubocopResult] match {
        case JsSuccess(rubocopResult, _) =>
          Success(
            rubocopResult.files.getOrElse(Seq.empty).flatMap {
              file => ruboFileToResult(file)
            }
          )
        case JsError(err) =>
          Failure(new Throwable(Json.stringify(JsError.toFlatJson(err))))
      }
    }
  }

  private[this] def ruboFileToResult(rubocopFiles: RubocopFiles): Iterable[Result] = {
    rubocopFiles.offenses.getOrElse(Seq.empty).map { case offense =>
      Issue(SourcePath(rubocopFiles.path.value), ResultMessage(offense.message.value),
        PatternId(getIdByPatternName(offense.cop_name.value)), ResultLine(offense.location.line))
    }
  }

  private[this] def getCommandFor(path: Path, conf: Option[Seq[PatternDef]], files: Option[Set[Path]], spec: Spec, outputFilePath: Path): Seq[String] = {
    val configPath = conf.flatMap(getConfigFile(_).map { configFile =>
      Seq("-c", configFile.toAbsolutePath.toString)
    }).getOrElse(Seq.empty)

    val patternsCmd = (for {
      patterns <- conf.getOrElse(Seq.empty)
    } yield getPatternNameById(patterns.patternId)) match {
      case patterns if patterns.nonEmpty => Seq("--only", patterns.mkString(","))
      case _ => Seq.empty
    }

    val filesCmd = files.getOrElse(Seq(path.toAbsolutePath)).map(_.toString)

    Seq("rubocop", "-f", "json", "-o", outputFilePath.toAbsolutePath.toString) ++ configPath ++ patternsCmd ++ filesCmd
  }

  private[this] lazy val resultFilePath = Paths.get(Properties.tmpDir, "rubocop-result.json")

  private[this] def getConfigFile(conf: Seq[PatternDef]): Option[Path] = {
    val rules = for {
      pattern <- conf
    } yield generateRule(pattern.patternId, pattern.parameters)

    val ymlConfiguration =
      s"""
         |AllCops:
         |  Include:
         |    - "**/*.gemspec"
         |    - "**/*.podspec"
         |    - "**/*.jbuilder"
         |    - "**/*.rake"
         |    - "**/*.opal"
         |    - "**/Gemfile"
         |    - "**/Rakefile"
         |    - "**/Capfile"
         |    - "**/Guardfile"
         |    - "**/Podfile"
         |    - "**/Thorfile"
         |    - "**/Vagrantfile"
         |    - "**/Berksfile"
         |    - "**/Cheffile"
         |    - "**/Vagabondfile"
         |  Exclude:
         |    - "vendor/**/*"
         |    - "db/schema.rb"
         |  RunRailsCops: false
         |  DisplayCopNames: false
         |  StyleGuideCopsOnly: false
         |  UseCache: false
         |${rules.mkString(s"${Properties.lineSeparator}")}
      """.stripMargin

    fileForConfig(ymlConfiguration).toOption
  }

  private[this] def fileForConfig(config: String) = tmpFile(config.toString)

  private[this] def tmpFile(content: String, prefix: String = "config", suffix: String = ".yml"): Try[Path] = {
    Try {
      Files.write(
        Files.createTempFile(prefix, suffix),
        content.getBytes(StandardCharsets.UTF_8),
        StandardOpenOption.CREATE
      )
    }
  }

  private[this] def generateRule(patternId: PatternId, parameters: Option[Set[ParameterDef]]): String = {
    val ymlProperties = parameters.map {
      parameterDef =>
        parameterDef.map {
          pattern => generateParameter(pattern)
        }
    }.getOrElse(Set.empty)
    val patternConfig = s"""
          |${getPatternNameById(patternId)}:
          |  Enabled: true
          |  ${ymlProperties.mkString(s"${Properties.lineSeparator}  ")}
    """.stripMargin

    if (parameters.nonEmpty) {
      patternConfig
    } else {
      ""
    }
  }


  private[this] def getPatternNameById(patternId: PatternId): String = {
    patternId.value.replace('_', '/')
  }

  private[this] def getIdByPatternName(id: String): String = {
    id.replace('/', '_')
  }

  private[this] def generateParameter(parameter: ParameterDef): String = {
    parameter.value match {
      case JsString(value) => s"${parameter.name.value}: $value"
      case JsArray(parameters) =>
        val finalParameters = parameters.map {
          case JsString(value) => value
          case other => Json.stringify(other)
        }.mkString(s"${Properties.lineSeparator}    - ")
        s"""${parameter.name.value}:
           |    - $finalParameters
         """.stripMargin
      case other => s"${parameter.name.value}: ${Json.stringify(other)}"
    }
  }

}
