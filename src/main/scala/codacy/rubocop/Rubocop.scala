package codacy.rubocop

import java.nio.file.Path

import codacy.dockerApi._
import codacy.dockerApi.utils.CommandRunner
import play.api.libs.json._
import better.files._

import scala.util.{Failure, Properties, Success, Try}

object Rubocop extends Tool {

  val configFile = File(DockerEnvironment.sourcePath) / ".rubocop.yml"

  override def apply(path: Path, conf: Option[List[PatternDef]], files: Option[Set[Path]])(implicit spec: Spec): Try[List[Result]] = {
    val cmd = getCommandFor(path, conf, files, spec, resultFilePath)
    CommandRunner.exec(cmd, Some(path.toFile))
    val resultFromTool = getFileLines(resultFilePath)
    parseResult(resultFromTool)
  }

  private[this] def getFileLines(filename: File): String = {
    filename.contentAsString
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
    rubocopFiles.offenses.getOrElse(List.empty).map { case offense =>
      Issue(SourcePath(rubocopFiles.path.value), ResultMessage(offense.message.value),
        PatternId(getIdByPatternName(offense.cop_name.value)), ResultLine(offense.location.line))
    }
  }

  private[this] def getCommandFor(path: Path, conf: Option[List[PatternDef]], files: Option[Set[Path]], spec: Spec, outputFilePath: File): List[String] = {

    val configPath: List[String] = {
      if(configFile.isRegularFile) List.empty
      else{
        conf.flatMap(getConfigFile(_).map { configFile =>
          List("-c", configFile.path.toAbsolutePath.toString)
        }).getOrElse(List.empty)
      }
    }

    val patternsCmd = {
      if(configFile.isRegularFile) List.empty
      else{
        (for {
          patterns <- conf.getOrElse(List.empty)
        } yield getPatternNameById(patterns.patternId)) match {
          case patterns if patterns.nonEmpty => List("--only", patterns.mkString(","))
          case _ => List.empty
        }
      }
    }

    val filesCmd = files.getOrElse(List(path.toAbsolutePath)).map(_.toString)

    List("rubocop", "-f", "json", "-o", outputFilePath.path.toAbsolutePath.toString) ++ configPath ++ patternsCmd ++ filesCmd
  }

  private[this] lazy val resultFilePath = File.temp / "rubocop-result.json"

  private[this] def getConfigFile(conf: List[PatternDef]): Option[File] = {
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

  private[this] def fileForConfig(config: String) = Try{
    File.newTemporaryFile(prefix = "config",suffix = ".yml").write(config)
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
