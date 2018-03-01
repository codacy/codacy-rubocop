package codacy.rubocop

import java.io.File

import com.fasterxml.jackson.core.JsonParser.Feature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.typesafe.config.ConfigFactory
import play.api._
import play.api.libs.json._
import play.api.libs.ws._
import play.api.libs.ws.ning._

import scala.concurrent.Await
import scala.concurrent.duration._

object Generator {

  def main(args: Array[String]): Unit = {
    val version = args.headOption.getOrElse {
      throw new Exception("Version is required")
    }

    val filesName = Set("default", "disabled", "enabled")
    val mergedJson = withClient { implicit client =>
      filesName.map { fileName =>
        val cops = getConfig(version, fileName)

        def yamlReader: ObjectMapper = new ObjectMapper(new YAMLFactory())
          .configure(Feature.ALLOW_COMMENTS, true)
          .configure(Feature.AUTO_CLOSE_SOURCE, true)
          .configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
          .configure(Feature.ALLOW_SINGLE_QUOTES, true)
          .configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true)

        Json.parse(yamlReader.readTree(cops).toString).as[JsObject]
      }.foldLeft(Json.obj()) { case (jsonAcc, json) => jsonAcc.deepMerge(json) }
    }
    val patterns = generatePatterns(mergedJson)
    val patternsJsonString = Json.prettyPrint(
      Json.obj(
        "name" -> "Rubocop",
        "version" -> version,
        "patterns" -> Json.parse(Json.toJson(patterns).toString).as[JsArray]
      )
    )

    val oldParamDescriptions: Map[String, JsArray] = ResourceHelper.getResourceContent("docs/description/description.json")
      .toOption.fold(Map.empty[String, JsArray]) { lines =>
      Json.parse(lines.mkString("\n"))
        .as[Array[JsObject]]
        .flatMap { obj =>
          obj.\("parameters").asOpt[JsArray].fold(Option.empty[(String, JsArray)]) { parameters =>
            Option((obj.\("patternId").as[String], parameters))
          }
        }(collection.breakOut)
    }
    val descriptions = generateDescriptions(mergedJson, oldParamDescriptions)
    val descriptionsJsonString = Json.prettyPrint(Json.parse(Json.toJson(descriptions).toString).as[JsArray])

    val repoRoot = new java.io.File(".")
    val docsRoot = new java.io.File(repoRoot, "src/main/resources/docs")
    val patternsFile = new java.io.File(docsRoot, "patterns.json")
    val descriptionsRoot = new java.io.File(docsRoot, "description")
    val descriptionsFile = new java.io.File(descriptionsRoot, "description.json")

    ResourceHelper.writeFile(patternsFile.toPath, patternsJsonString)
    ResourceHelper.writeFile(descriptionsFile.toPath, descriptionsJsonString)
  }

  private def withClient[T](f: NingWSClient => T): T = {
    val configuration = Configuration.reference ++
      Configuration(ConfigFactory.parseString(
        """
          |ws.followRedirects = true
        """.stripMargin)
      )
    val environment = Environment(new File("."), this.getClass.getClassLoader, Mode.Prod)
    val parser = new WSConfigParser(configuration, environment)
    val config = NingWSClientConfig(wsClientConfig = parser.parse())
    val asyncConfig = new NingAsyncHttpClientConfigBuilder(config).build()
    val client = NingWSClient(asyncConfig)

    val res = f(client)

    client.close()

    res
  }

  private def getConfig(version: String, fname: String)(implicit client: NingWSClient): String = {
    val url = s"https://raw.githubusercontent.com/bbatsov/rubocop/v$version/config/$fname.yml"
    Await.result(client.url(url).get(), 30.seconds).body
  }

  private def generatePatterns(json: JsObject): JsArray = {
    val allPatterns = json.value.collect {
      case (pattern, JsObject(obj)) =>
        val specs = obj.filterNot {
          case (key, _) =>
            key.startsWith("Supported") ||
              key.startsWith("StyleGuide") ||
              key.startsWith("Enabled") ||
              key.startsWith("Description") ||
              key.startsWith("Reference") ||
              key.startsWith("AutoCorrect")
        }

        (pattern.replace("/", "_"), specs)
    }

    val codacyPatterns = allPatterns.collect {
      case (pattern, parameterMap) =>
        val level = if (pattern.startsWith("Lint") ||
          pattern.startsWith("Metrics") ||
          pattern.startsWith("Performance") ||
          pattern.startsWith("Rails")) {
          "Warning"
        } else {
          "Info"
        }

        val category = if (pattern.startsWith("Lint") ||
          (pattern.startsWith("Metrics") && !pattern.contains("Length") && !pattern.contains("AbcSize")) ||
          pattern.startsWith("Rails")) {
          "ErrorProne"
        } else if (pattern.startsWith("Performance")) {
          "Performance"
        } else if (pattern.startsWith("Security")) {
          "Security"
        } else {
          "CodeStyle"
        }

        val basePattern = Json.obj(
          "patternId" -> pattern,
          "level" -> level,
          "level" -> level,
          "category" -> category
        )

        if (parameterMap.keys.nonEmpty) {
          val params: List[JsObject] = parameterMap.map { case (key, value) => Json.obj("name" -> key, "default" -> value) }(collection.breakOut)
          val paramsMap: JsArray = Json.arr(params.map(Json.toJsFieldJsValueWrapper(_)): _*)

          basePattern ++ Json.obj(
            "parameters" -> paramsMap
          )
        } else {
          basePattern
        }
    }

    Json.parse(Json.toJson(codacyPatterns).toString).as[JsArray]
  }

  private def generateDescriptions(json: JsObject, oldParamDescriptions: Map[String, JsArray]): JsArray = {
    val allPatternsWithDescs = json.value.collect {
      case (pattern, JsObject(obj)) =>
        val descriptions = obj.filterNot {
          case (key, _) =>
            key.startsWith("Supported") ||
              key.startsWith("StyleGuide") ||
              key.startsWith("Enabled") ||
              key.startsWith("Reference") ||
              key.startsWith("AutoCorrect")
        }

        (pattern.replace("/", "_"), descriptions)
    }

    val codacyPatternsDescs = allPatternsWithDescs.collect {
      case (pattern, parameterMap) if parameterMap.get("Description").isDefined =>
        val params = oldParamDescriptions.get(pattern).fold(Json.obj())(params => Json.obj(("parameters", params)))

        val basePattern = Json.obj(
          "patternId" -> pattern,
          "title" -> parameterMap("Description"),
          "description" -> parameterMap("Description"),
          "timeToFix" -> 5
        ) ++ params
        basePattern
    }

    Json.parse(Json.toJson(codacyPatternsDescs).toString).as[JsArray]
  }

}
