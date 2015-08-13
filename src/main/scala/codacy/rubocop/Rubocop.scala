package codacy.rubocop

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths, StandardOpenOption}

import codacy.dockerApi._
import play.api.libs.json._

import scala.sys.process._
import scala.util.{Failure, Properties, Success, Try}
import scala.xml.{Elem, XML}
import java.io.File

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
    if(jsonParsed.validate[RubocopResult].isError) {
      println("Could not validate json")
      None
    } else {
      jsonParsed.as[RubocopResult]
    }
  }

  private[this] def parseResult(resultFromTool: String): Try[Iterable[Result]] = {
    Try(Json.parse(resultFromTool)).flatMap{ case json =>
      json.validate[RubocopResult] match{
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
        val result:Result = ??? //turn offense into a result

        result
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

  private[this] def xmlLocation(ruleName: String, ruleSet: String): Option[String] = {
    RuleType.get(ruleSet).map { ruleString => 
      s"$ruleString$ruleName" 
    }
  }

  private[this] lazy val outputParsed(outputJson: Elem)(implicit spec: Spec) = {
    val jsonText = Json.parse()
  }

  private[this] def patternIdByRuleNameAndRuleSet (ruleName: String, ruleSet: String)(implicit spec: Spec): Option[PatternId] = {
    spec.patterns.collectFirst { case pattern if xmlLocation(ruleName, ruleSet).contains(pattern.patternId.value) =>
      pattern.patternId 
    }
  }
  
  private[this] def patternIdByRuleNameAndRuleSet(ruleName: String, ruleSet: String)(implicit spec: Spec): Option[PatternId] = {
    spec.patterns.collectFirst {case pattern if xmlLocation(ruleName, ruleSet).contains(pattern.patternId.value) =>
      pattern.patternId 
    }
  }

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

  private[this] def fileForConfig(config: String) = tmpFile(config.toString())

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
