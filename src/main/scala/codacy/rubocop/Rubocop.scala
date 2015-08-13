package codacy.rubocop

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths, StandardOpenOption}

import codacy.dockerApi._
import play.api.libs.json._

import scala.sys.process._
import scala.util.{Failure, Properties, Success, Try}
import java.io.File

final class RuboResultColumn  (val value:Int    ) extends AnyVal{ override def toString = value.toString }
final class RuboResultLength  (val value:Int    ) extends AnyVal{ override def toString = value.toString }
final class ParameterName     (val value:String ) extends AnyVal{ override def toString = value.toString }
final class Version           (val value:String ) extends AnyVal{ override def toString = value.toString }
final class RubyEngine        (val value:String ) extends AnyVal{ override def toString = value.toString }
final class RubyVersion       (val value:String ) extends AnyVal{ override def toString = value.toString }
final class RubyPatchLevel    (val value:String ) extends AnyVal{ override def toString = value.toString }
final class RubyPlatform      (val value:String ) extends AnyVal{ override def toString = value.toString }
final class Severity          (val value:String ) extends AnyVal{ override def toString = value.toString }
final class Corrected         (val value:Boolean) extends AnyVal{ override def toString = value.toString }
final class OffenseCount      (val value:Int    ) extends AnyVal{ override def toString = value.toString }
final class TrgtFileCount     (val value:Int    ) extends AnyVal{ override def toString = value.toString }
final class InspFileCount     (val value:Int    ) extends AnyVal{ override def toString = value.toString }

object ParameterName    extends Formats[ParameterName   , String ]( new ParameterName(_)   )
object RuboResultColumn extends Formats[RuboResultColumn, Int    ]( new RuboResultColumn(_))
object RuboResultLength extends Formats[RuboResultLength, Int    ]( new RuboResultLength(_))
object Version          extends Formats[Version         , String ]( new Version(_)         )
object RubyEngine       extends Formats[RubyEngine      , String ]( new RubyEngine(_)      )
object RubyVersion      extends Formats[RubyVersion     , String ]( new RubyVersion(_)     )
object RubyPatchLevel   extends Formats[RubyPatchLevel  , String ]( new RubyPatchLevel(_)  )
object RubyPlatform     extends Formats[RubyPlatform    , String ]( new RubyPlatform(_)    )
object Severity         extends Formats[Severity        , String ]( new Severity(_)        )
object Corrected        extends Formats[Corrected       , Boolean]( new Corrected(_)       )
object OffenseCount     extends Formats[OffenseCount    , Int    ]( new OffenseCount(_)    )
object TrgtFileCount    extends Formats[TrgtFileCount   , Int    ]( new TrgtFileCount(_)   )
object InspFileCount    extends Formats[InspFileCount   , Int    ]( new InspFileCount(_)   )


case class RubocopLocation(line:ResultLine, column:RuboResultColumn, length:RuboResultLength)
case class RubocopMetadata(rubocopVersion:Version, rubyEngine:RubyEngine, rubyVersion:RubyVersion, rubyPatchLevel:RubyPatchLevel, rubyPlatform:RubyPlatform)
case class RubocopOffenses(severity:Severity, message:ResultMessage, copName:PatternId, corrected:Corrected, location:RubocopLocation)
case class RubocopFiles(path:SourcePath, offenses:Option[Seq[RubocopOffenses]])
case class RubocopSummary(offenseCount:OffenseCount, targetFileCount:TrgtFileCount, inspectedFileCount:InspFileCount)
case class RubocopResult(metadata:RubocopMetadata, files:Option[Seq[RubocopFiles]], summary:RubocopSummary)

object Rubocop extends Tool {

  override def apply(path: Path, conf: Option[Seq[PatternDef]], files: Option[Set[Path]])(implicit spec: Spec): Try[Iterable[Result]] = {
    getCommandFor(path, conf, files, spec, resultFilePath).flatMap { case cmd =>
      cmd.!(discardingLogger)
      val resultFromTool = getFileLines(resultFilePath.toFile)
      parseResult(resultFromTool)
    }
  }

  private[this] def getFileLines(filename: File): String = {
    scala.io.Source.fromFile(filename).getLines().mkString
  }

  private[this] def getRubocopResult(jsonParsed: JsValue): Option[RubocopResult] = {
    jsonParsed.asOpt[RubocopResult]
  }

  private[this] def parseResult(resultFromTool: String): Try[Iterable[Result]] = {
    Try(Json.parse(resultFromTool)).flatMap{ case json =>
      json.validate[RubocopResult] match {
        case JsSuccess(rubocopResult,_) =>
          Success(
            rubocopResult.files.getOrElse(Seq.empty).flatMap( ruboFileToResult )
          )
        case JsError(err) =>
          Failure(new Throwable(Json.stringify(JsError.toFlatJson(err))))
      }
    }
  }

  private[this] def ruboFileToResult(rubocopResult:RubocopFiles): Iterable[Result] = {
    //transform the result into a list of results
      rubocopResult.offenses.getOrElse(Seq.empty).map{ case offense =>
        Result(rubocopResult.path, offense.message, offense.copName, offense.location.line)
      }
  }

  private[this] lazy val ruleSetsDefault = Seq(
    "Lint", "Metrics", "Metrics/LineLength", "Performance", "Rails", "Rails/ActionFilter", "Rails/Delegate",
    "Rails/HasAndBelongsToMany", "Rails/TimeZone", "Rails/Validation", "Style"
  ).map { case group => s"ruby-$group" }.mkString(",")

  private[this] def getCommandFor(path: Path, conf: Option[Seq[PatternDef]], files: Option[Set[Path]], spec: Spec, outputFilePath: Path): Try[Seq[String]] = {
    val configPath = conf.map(getConfigFile(_).map(_.toAbsolutePath.toString)).getOrElse(Success(ruleSetsDefault))

    configPath.map { case configuration =>
        val configurationCmd = Seq("-rulesets", configuration)

        val filesCmd = files.map(_.mkString(",")).getOrElse(path.toAbsolutePath.toString)

        Seq("rubocop", "-d", filesCmd, "-f", "json", "-o", outputFilePath.toAbsolutePath.toString) ++ configurationCmd
    }
  }

  private[this] lazy val discardingLogger = ProcessLogger((_: String) => ())

  private[this] lazy val resultFilePath = Paths.get(Properties.tmpDir, "rubocop-result.json")

  private[this] def getConfigFile(conf: Seq[PatternDef]): Try[Path] = {
    val rules = for {
      pattern <- conf
      patternConfiguration <- generateRule(pattern.patternId, pattern.parameters)
    } yield patternConfiguration

    val ymlConfiguration =
      s""""
         |AllCops:
         |  Include:
         |  - "**/*.gemspec"
         |  - "**/*.podspec"
         |  - "**/*.jbuilder"
         |  - "**/*.rake"
         |  - "**/*.opal"
         |  - "**/Gemfile"
         |  - "**/Rakefile"
         |  - "**/Capfile"
         |  - "**/Guardfile"
         |  - "**/Podfile"
         |  - "**/Thorfile"
         |  - "**/Vagrantfile"
         |  - "**/Berksfile"
         |  - "**/Cheffile"
         |  - "**/Vagabondfile"
         |  Exclude:
         |  - "vendor/**/*"
         |  - "db/schema.rb"
         |  RunRailsCops: false
         |  DisplayCopNames: false
         |  StyleGuideCopsOnly: false
         |  ${rules}
      """


    fileForConfig(ymlConfiguration)
  }

  private[this] def fileForConfig(config: String) = tmpFile(config.toString)

  private[this] def tmpFile(content: String, prefix: String = "ruleset", suffix: String = ".xml"): Try[Path] = {
    Try(Files.write(
      Files.createTempFile(prefix, suffix),
      content.getBytes(StandardCharsets.UTF_8),
      StandardOpenOption.CREATE
      ))
  }
  
  private[this] def getPatternNameById(patternId: PatternId): String = {
    patternId.value.replace('_', '/')
  }

  private[this] def generateRule(patternId: PatternId, parameters: Option[Set[ParameterDef]]): String = {
    val ymlProperties = parameters.map(_.map(generateParameter)).getOrElse(Seq.empty)

    s"""
      |${getPatternNameById(patternId)}
      |  ${ymlProperties}
    """
  }

  private[this] def generateParameter(parameter: ParameterDef): String = {
    val parameterValue = parameter.value match {
      case JsString(value) => value
      case other => Json.stringify(other)
    }
    s"${parameter.name}: ${parameterValue}"
  }

  private object RuleType {
    val values = Map(
      "Lint" -> "rulesets_ruby_linter.json",
      "Metrics" -> "rulesets_ruby_metrics.json",
      "Metrics/LineLength" -> "rulesets_ruby_metrics_linelength.json",
      "Performance" -> "rulesets_ruby_performance.json",
      "Rails" -> "rulesets_ruby_rails.xml",
      "Rails/ActionFilter" -> "rulesets_ruby_rails_actionfilter.xml",
      "Rails/Delegate" -> "rulesets_ruby_rails_delegate.xml",
      "Rails/HasAndBelongsToMany" -> "rulesets_ruby_rails_hasandbelongstomany.xml",
      "Rails/TimeZone" -> "rulesets_ruby_rails_timezone.xml",
      "Rails/Validation" -> "rulesets_ruby_rails_validation.xml",
      "Style" -> "rulesets_ruby_style.xml"
      )

    def get(value: String): Option[String] = values.get(value)
  }

}
