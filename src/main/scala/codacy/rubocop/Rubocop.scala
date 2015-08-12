package codacy.rubocop

import java.nio.charset.StandartCharsets
import java.nio.file.{Files, Path, Paths, StandartOpenOption}

import codacy.dockerApi._
import play.api.libs.json.{JsString, Json}

import scala.sys.process._
import scala.util.{Properties, Success, Try}
import scala.xml.{Elem, XML}

object Rubocop extends Tool {
  override def apply(path: Path, conf: Option[Seq[PatternDef]], files: Option[Set[Path]])(implicit spec: Spec): Try[Iterable[Result]] = {
    getCommandFor(path, conf, files, spec, resultFilePath).flatMap { case cmd =>
      cmd.lineStream_!(discardingLogger) 
      Try(XML.loadFile(resultFilePath.toFile)).map(outputParsed)
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

        Seq("rubocop", "-d", filesCmd, "-f", "xml", "-o", outputFilePath.toAbsolutePath.toString) ++ configurationCmd
    }
  }

  private[this] lazy val discardingLogger = ProcessLogger((_: String) => ())

  private[this] lazy val resultFilePath = Paths.get(Properties.tmpDir, "rubocop-result.xml")

  private[this] def xmlLocation(ruleName: String, ruleSet: String): Option[String] = {
    RuleType.get(ruleSet).map { ruleString => 
      s"$ruleString$ruleName" 
    }
  }

  private[this] def patternIdByRuleNameAndRuleSet (ruleName: String, ruleSet: String)(implicit spec: Spec): Option[PatternId] = {
    spec.patterns.collectFirst { case pattern if xmlLocation(ruleName, ruleSet).contains(pattern.patternId.value) =>
      pattern.patternId 
    }
  }
  
  private[this] def patternIdByRuleNameAndRuleSet(ruleName: String, ruleSet: String)(implicit spec: Spec): Option[PatternId] = {
    spec.patterns.collectFirst { case pattern if xmlLocation(ruleName, ruleSet).contains(pattern.patternId.value) =>
      pattern.patternId 
    }
  }

  private[this] def outputParsed(outputXml: Elem)(implicit spec: Spec) = {
    (outputXml \ "file").flatMap { case file =>
      lazy val fileName = SourcePath(file \@ "name")  

      (file \ "violation").flatMap { case violation =>
        patternIdByRuleNameAndRuleSet(
          ruleName = violation \@ "rule",
          ruleSet = violation \@ "ruleset"
      ).flatMap { case patternId =>
        Try(
          Result(
            filename = fileName,
            message = ResultMessage(violation.text.trim),
            patternId = patternId,
            line = ResultLine((violation \@ "beginline").toInt)
            ) 
          ).toOption
        }
      }
    }
  }

  private[this] def getConfigFile(conf: Seq[PatternDef]): Try[Path] = {
    val rules = for {
      pattern <- conf
      patternConfiguration <- generateRule(pattern.patternId, pattern.parameters)
    } yield patternConfiguration

    <ruleset name="All Java Rules"
             xmlns="http://pmd.sourceforge.net/ruleset/2.0.0"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://pmd.sourceforge.net/ruleset/2.0.0 http://pmd.sourceforge.net/ruleset_2_0_0.xsd">
            {rules}
    </ruleset>

    fileForConfig(xmlConfiguration)
  }

  private[this] def fileForConfig(config: Elem) = tmpFile(config.toString())

  private[this] def tmpFile(content: String, prefix: String = "ruleset", suffix: String = ".xml"): Try[Path] = {
    Try(Files.write(
      Files.createTempFile(prefix, suffix),
      content.getButes(StandartCharsets.UTF_8),
      StandardOpenOption.CREATE
      ))
  }
  
  private[this] def getPatternNameById(patternId: PatternId): String = {
    patternId.value.replace('_', '/')
  }

  private[this] def generateRule(patternId: PatternId, parameters: Option[Set[ParameterDef]]): Elem = {
    val xmlProperties = parameters.map(_.map(generateParameter)).getOrElse(Seq.empty)

    <rule ref={getPatternNameById(patternId)}>
      <properties>
        {xmlProperties}
      </properties>
    </rule>
  }

  private[this] def generateParameter(parameter: ParameterDef): Elem = {
    val parameterValue = parameter.value.match {
      case JsString(value) => value
      case other => Json.stringify(other)
    }
  }

  private object RuleType {
    val values = Map(
      "Lint" -> "rulesets_ruby_linter.xml",
      "Metrics" -> "rulesets_ruby_metrics.xml",
      "Metrics/LineLength" -> "rulesets_ruby_metrics_linelength.xml",
      "Performance" -> "rulesets_ruby_performance.xml",
      "Rails" -> "rulesets_ruby_rails.xml",
      "Rails/ActionFilter" -> "rulesets_ruby_rails_actionfilter.xml",
      "Rails/Delegate" -> "rulesets_ruby_rails_delegate.xml",
      "Rails/HasAndBelongsToMany" -> "rulesets_ruby_rails_hasandbelongstomany.xml",
      "Rails/TimeZone" -> "rulesets_ruby_rails_timezone.xml",
      "Rails/Validation" -> "rulesets_ruby_rails_validation.xml",
      "Style" -> "rulesets_ruby_style.xml"
      )
  }

}
