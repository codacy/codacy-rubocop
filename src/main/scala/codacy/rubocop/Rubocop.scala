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

  override def apply(path: Path, conf: Option[List[PatternDef]], files: Option[Set[Path]])(implicit spec: Spec): Try[List[Result]] = {
    val cmd = getCommandFor(path, conf, files, spec, resultFilePath)
    CommandRunner.exec(cmd, Some(path.toFile))
    val resultFromTool = getFileLines(resultFilePath.toFile)
    parseResult(resultFromTool)
  }

  private[this] def getFileLines(filename: File): String = {
    Source.fromFile(filename).getLines().mkString
  }

  private[this] def parseResult(resultFromTool: String): Try[List[Result]] = {
    Try(Json.parse(resultFromTool)).flatMap { json =>
      json.validate[RubocopResult] match {
        case JsSuccess(rubocopResult, _) =>
          Success(
            rubocopResult.files.getOrElse(List.empty).flatMap {
              file => ruboFileToResult(file)
            }
          )
        case JsError(err) =>
          Failure(new Throwable(Json.stringify(JsError.toFlatJson(err))))
      }
    }
  }

  private[this] def ruboFileToResult(rubocopFiles: RubocopFiles): List[Result] = {
    rubocopFiles.offenses.getOrElse(List.empty).map { offense =>
      Issue(SourcePath(rubocopFiles.path.value), ResultMessage(offense.message.value),
        PatternId(getIdByPatternName(offense.cop_name.value)), ResultLine(offense.location.line))
    }
  }

  private[this] def getCommandFor(path: Path, conf: Option[List[PatternDef]], files: Option[Set[Path]], spec: Spec, outputFilePath: Path): List[String] = {
    val configPath = conf.flatMap(getConfigFile(_).map { configFile =>
      List("-c", configFile.toAbsolutePath.toString)
    }).getOrElse(List.empty)

    val patternsCmd = (for {
      patterns <- conf.getOrElse(List.empty)
    } yield getPatternNameById(patterns.patternId)) match {
      case patterns if patterns.nonEmpty => List("--only", patterns.mkString(","))
      case _ => List.empty
    }

    val filesCmd = files.getOrElse(List(path.toAbsolutePath)).map(_.toString)

    List("rubocop", "-f", "json", "-o", outputFilePath.toAbsolutePath.toString) ++ configPath ++ patternsCmd ++ filesCmd
  }

  private[this] lazy val resultFilePath = Paths.get(Properties.tmpDir, "rubocop-result.json")

  private[this] def getConfigFile(conf: List[PatternDef]): Option[Path] = {
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
    val patternConfig =
      s"""
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
      case JsArray(parameters) if parameters.nonEmpty =>
        val finalParameters = parameters.map(p => s"    - ${Json.stringify(p)}")
          .mkString(Properties.lineSeparator)
        s"""${parameter.name.value}:
           |$finalParameters
         """.stripMargin

      case JsArray(parameters) =>
        s"""${parameter.name.value}: []
         """.stripMargin

      case other => s"${parameter.name.value}: ${Json.stringify(other)}"
    }
  }

}
