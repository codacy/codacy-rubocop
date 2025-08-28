package codacy.rubocop

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path, Paths, StandardOpenOption}

import com.codacy.plugins.api
import com.codacy.plugins.api.results.Result.Issue
import com.codacy.plugins.api.results.Tool.Specification
import com.codacy.plugins.api.results.{Parameter, Pattern, Result, Tool}
import com.codacy.plugins.api.{paramValueToJsValue, Options}
import com.codacy.tools.scala.seed.utils.CommandRunner
import play.api.libs.json._

import scala.io.Source
import scala.util.{Failure, Properties, Success, Try}

object Rubocop extends Tool {
  private val plugins: List[String] =
    List(
      "rubocop-performance",
      "rubocop-rails",
      "rubocop-sorbet",
      "rubocop-graphql",
      "rubocop-thread_safety",
      "rubocop-minitest",
      "rubocop-rake",
      "rubocop-rspec",
      "rubocop-i18n",
      "rubocop-faker",
      "rubocop-factory_bot",
      "rubocop-md",
      "rubocop-mdsol",
      "rubocop-rspec_rails",
      "rubocop-capybara",
      "rubocop-gitlab-security",
      "rubocop-haml",
      "rubocop-packaging",
      "rubocop-rubycw",
      "rubocop-packs",
      "rubocop-ast",
      "./ext.rb"
    )

  // Gemfile is analysed
  private val filesToIgnore: Set[String] =
    Set("Gemfile.lock").map(_.toLowerCase())

  override def apply(
      source: api.Source.Directory,
      configuration: Option[List[Pattern.Definition]],
      files: Option[Set[api.Source.File]],
      options: Map[Options.Key, Options.Value]
  )(implicit specification: Tool.Specification): Try[List[Result]] = {

    val cmd = getCommandFor(Paths.get(source.path), configuration, files, specification, resultFilePath)
    CommandRunner.exec(cmd, Some(new File(source.path))) match {

      case Right(resultFromTool) if resultFromTool.exitCode < 2 =>
        parseResult(resultFilePath.toFile) match {
          case s @ Success(_) => s
          case Failure(e) =>
            val msg =
              s"""
                 |Rubocop exited with code ${resultFromTool.exitCode}
                 |message: ${e.getMessage}
                 |stdout: ${resultFromTool.stdout.mkString(Properties.lineSeparator)}
                 |stderr: ${resultFromTool.stderr.mkString(Properties.lineSeparator)}
                """.stripMargin
            Failure(new Exception(msg))
        }

      case Right(resultFromTool) =>
        val msg =
          s"""
             |Rubocop exited with code ${resultFromTool.exitCode}
             |stdout: ${resultFromTool.stdout.mkString(Properties.lineSeparator)}
             |stderr: ${resultFromTool.stderr.mkString(Properties.lineSeparator)}
                """.stripMargin
        Failure(new Exception(msg))

      case Left(e) =>
        Failure(e)
    }
  }

  private[this] def parseResult(filename: File): Try[List[Result]] = {
    Try {
      val resultFromTool = Source.fromFile(filename).getLines().mkString
      Json.parse(resultFromTool)
    }.flatMap { json =>
      json.validate[RubocopResult] match {
        case JsSuccess(rubocopResult, _) =>
          Success(rubocopResult.files.getOrElse(List.empty).flatMap { file =>
            ruboFileToResult(file)
          })
        case JsError(err) =>
          Failure(new Throwable(Json.stringify(JsError.toJson(err))))
      }
    }
  }

  private[this] def ruboFileToResult(rubocopFiles: RubocopFiles): List[Result] = {
    rubocopFiles.offenses.getOrElse(List.empty).map { offense =>
      Issue(
        api.Source.File(rubocopFiles.path.value),
        Result.Message(offense.message.value),
        Pattern.Id(getIdByPatternName(offense.cop_name.value)),
        api.Source.Line(offense.location.line)
      )
    }
  }

  private[this] def getCommandFor(
      path: Path,
      conf: Option[List[Pattern.Definition]],
      files: Option[Set[api.Source.File]],
      spec: Specification,
      outputFilePath: Path
  ): List[String] = {
    val configFile = conf match {
      // is using UI configuration
      case Some(patterns) => getConfigFile(patterns)
      // is not using UI configuration
      case None =>
        val customCodacyConfigFile = path.resolve(".rubocop-codacy.yml")
        Option.when(Files.exists(customCodacyConfigFile))(customCodacyConfigFile)
    }

    val configFileOptions = configFile match {
      case Some(file) => List("-c", file.toString)
      case None => List.empty
    }

    val patternsCmd = (for {
      patterns <- conf.getOrElse(List.empty)
    } yield getPatternNameById(patterns.patternId)) match {
      case patterns if patterns.nonEmpty =>
        List("--only", patterns.mkString(","))
      case _ => List.empty
    }

    val filesCmd = files
      .getOrElse(List(path.toAbsolutePath))
      .collect {
        case file if !filesToIgnore.contains(file.toString.toLowerCase) =>
          file.toString
      }

    List("rubocop", "--force-exclusion", "-f", "json", "-o", outputFilePath.toAbsolutePath.toString) ++ configFileOptions ++ patternsCmd ++ filesCmd
  }

  private[this] lazy val resultFilePath =
    Paths.get(Properties.tmpDir, "rubocop-result.json")

  private[this] def getConfigFile(conf: List[Pattern.Definition]): Option[Path] = {
    val rules = for {
      pattern <- conf
    } yield generateRule(pattern.patternId, pattern.parameters)

    val ymlRequires =
      s"""
         |require:
         |${plugins.map(plugin => s"  - $plugin").mkString(System.lineSeparator())}
         |""".stripMargin

    val ymlConfiguration =
      s"""
         |AllCops:
         |  Include:
         |    - '**/*.rb'
         |    - '**/*.arb'
         |    - '**/*.axlsx'
         |    - '**/*.gemfile'
         |    - '**/*.gemspec'
         |    - '**/*.jbuilder'
         |    - '**/*.opal'
         |    - '**/*.podspec'
         |    - '**/*.rake'
         |    - '**/buildfile'
         |    - '**/Berksfile'
         |    - '**/Capfile'
         |    - '**/Cheffile'
         |    - '**/Fastfile'
         |    - '**/*Fastfile'
         |    - '**/Gemfile'
         |    - '**/Guardfile'
         |    - '**/Podfile'
         |    - '**/Rakefile'
         |    - '**/Thorfile'
         |    - '**/Vagabondfile'
         |    - '**/Vagrantfile'
         |  Exclude:
         |    - "vendor/**/*"
         |    - "db/schema.rb"
         |    - ".git/**/*"
         |  DisplayCopNames: false
         |  StyleGuideCopsOnly: false
         |  UseCache: false
         |$ymlRequires
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

  private[this] def generateRule(patternId: Pattern.Id, parameters: Set[Parameter.Definition]): String = {
    val ymlProperties = parameters
      .map(generateParameter)
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

  private[this] def getPatternNameById(patternId: Pattern.Id): String = {
    patternId.value.replace('_', '/')
  }

  private[this] def getIdByPatternName(id: String): String = {
    id.replace('/', '_')
  }

  private[this] def generateParameter(parameter: Parameter.Definition): String = {
    paramValueToJsValue(parameter.value) match {
      case JsArray(parameters) if parameters.nonEmpty =>
        val finalParameters = parameters
          .map(p => s"    - ${Json.stringify(p)}")
          .mkString(Properties.lineSeparator)
        s"""${parameter.name.value}:
           |$finalParameters
         """.stripMargin

      case JsArray(_) =>
        s"""${parameter.name.value}: []
         """.stripMargin

      case other => s"${parameter.name.value}: ${Json.stringify(other)}"
    }
  }

}
