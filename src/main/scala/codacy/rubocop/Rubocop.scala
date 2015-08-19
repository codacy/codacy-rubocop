package codacy.rubocop

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths, StandardOpenOption}

import codacy.dockerApi._
import play.api.libs.json._

import scala.sys.process._
import scala.util.{Failure, Properties, Success, Try}
import java.io.File

case class RubocopLocation(line: Int, column: JsValue, length: JsValue)

case class RubocopMetadata(rubocop_version: JsValue, ruby_engine: JsValue, ruby_version: JsValue, ruby_patchlevel: JsValue, ruby_platform: JsValue)

case class RubocopOffense(severity: JsValue, message: JsString, cop_name: JsString, corrected: JsValue, location: RubocopLocation)

case class RubocopFiles(path: JsString, offenses: Option[Seq[RubocopOffense]])

case class RubocopSummary(offense_count: JsValue, target_file_count: JsValue, inspected_file_count: JsValue)

case class RubocopResult(metadata: RubocopMetadata, files: Option[Seq[RubocopFiles]], summary: RubocopSummary)

object RubocopResult {
  implicit val RLocation: Format[RubocopLocation] = {
    Json.format[RubocopLocation]
  }

  implicit val RMetaData: Format[RubocopMetadata] = {
    Json.format[RubocopMetadata]
  }

  implicit val ROffenses: Format[RubocopOffense] = {
    Json.format[RubocopOffense]
  }

  implicit val RFiles: Format[RubocopFiles] = {
    Json.format[RubocopFiles]
  }

  implicit val RSummary: Format[RubocopSummary] = {
    Json.format[RubocopSummary]
  }

  implicit val RResult: Format[RubocopResult] = {
    Json.format[RubocopResult]
  }
}

object Rubocop extends Tool {

  override def apply(path: Path, conf: Option[Seq[PatternDef]], files: Option[Set[Path]])(implicit spec: Spec): Try[Iterable[Result]] = {
    val cmd = getCommandFor(path, conf, files, spec, resultFilePath)
    println(cmd.mkString(" "))
    cmd.!(discardingLogger)
    println(cmd.lineStream_!.toList.mkString("\n"))
    val resultFromTool = getFileLines(resultFilePath.toFile)
    parseResult(resultFromTool)
  }

  private[this] def getFileLines(filename: File): String = {
    scala.io.Source.fromFile(filename).getLines().mkString
  }

  private[this] def parseResult(resultFromTool: String): Try[Iterable[Result]] = {
    Try(Json.parse(resultFromTool)).flatMap { case json =>
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
    println(rubocopFiles.path)
    rubocopFiles.offenses.getOrElse(Seq.empty).map { case offense =>
      println(getIdByPatternName(offense.cop_name.value))
     Result(SourcePath(rubocopFiles.path.value), ResultMessage(offense.message.value), PatternId(getIdByPatternName(offense.cop_name.value)), ResultLine(offense.location.line))
    }
  }

  private[this] def getCommandFor(path: Path, conf: Option[Seq[PatternDef]], files: Option[Set[Path]], spec: Spec, outputFilePath: Path): Seq[String] = {
    val configPath = conf.flatMap(getConfigFile(_).map{ configFile =>
      println(configFile)
      Seq("-c", configFile.toAbsolutePath.toString)}).getOrElse(Seq.empty)

    val patternIds = for {
      patterns <- conf.getOrElse(Seq.empty)
    } yield getPatternNameById(patterns.patternId)

    val filesCmd = files.getOrElse(Seq(path.toAbsolutePath)).map(_.toString)

    Seq("rubocop", "-f", "json", "-o", outputFilePath.toAbsolutePath.toString) ++ configPath ++ Seq("--only", patternIds.mkString(",")) ++ filesCmd
  }

  private[this] lazy val discardingLogger = ProcessLogger((_: String) => ())

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
         |${rules.mkString(s"${Properties.lineSeparator}")}
      """.stripMargin

    println(ymlConfiguration)
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
      case JsString(value) => s"${parameter.name.value}: ${value}"
      case JsArray(parameters) =>
        val finalParameters = parameters.map {
          case JsString(value) => value
          case other => Json.stringify(other)
        }.mkString(s"${Properties.lineSeparator}    - ")
        s"""${parameter.name.value}:
           |    - ${finalParameters}
         """.stripMargin
      case other => s"${parameter.name.value}: ${Json.stringify(other)}"
    }
  }

  private object RuleType {
    val values = Map(
      "Lint" -> "rulesets_ruby_linter.json",
      "Metrics" -> "rulesets_ruby_metrics.json",
      "Metrics/LineLength" -> "rulesets_ruby_metrics_linelength.json",
      "Performance" -> "rulesets_ruby_performance.json",
      "Rails" -> "rulesets_ruby_rails.json",
      "Rails/ActionFilter" -> "rulesets_ruby_rails_actionfilter.json",
      "Rails/Delegate" -> "rulesets_ruby_rails_delegate.json",
      "Rails/HasAndBelongsToMany" -> "rulesets_ruby_rails_hasandbelongstomany.json",
      "Rails/TimeZone" -> "rulesets_ruby_rails_timezone.json",
      "Rails/Validation" -> "rulesets_ruby_rails_validation.json",
      "Style" -> "rulesets_ruby_style.json"
    )

    def get(value: String): Option[String] = values.get(value)
  }

}
