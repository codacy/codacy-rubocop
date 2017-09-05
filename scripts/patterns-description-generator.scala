import com.fasterxml.jackson.core.JsonParser.Feature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import play.api.libs.json._

def updatePatternsAndDescription(version: String): Unit = {
  val filesName = Set("default", "disabled", "enabled")

  val json = filesName.map { file =>
    val cops = scala.io.Source.fromFile(new java.io.File(s"rubocop-config-base-files/$file.yml")).getLines.toList.mkString("\n")

    def yamlReader: ObjectMapper = new ObjectMapper(new YAMLFactory()).configure(Feature.ALLOW_COMMENTS, true).configure(Feature.AUTO_CLOSE_SOURCE, true).configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).configure(Feature.ALLOW_SINGLE_QUOTES, true).configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true)

    Json.parse(yamlReader.readTree(cops).toString).as[JsObject]
  }.foldLeft(Json.obj()) { case (jsonAcc, json) => jsonAcc.deepMerge(json) }

  val patterns = generatePatterns(json, version)
  println(s"\n${Json.obj("name" -> "Rubocop", "version" -> version, "patterns" -> Json.parse(Json.toJson(patterns).toString).as[JsArray])}\n")

  val descriptions = generateDescriptions(json, version)
  println(s"\n${Json.parse(Json.toJson(descriptions).toString).as[JsArray]}\n")

  println("NOTE: Copy the parameters description from the old description.json th ")
}

def generatePatterns(json: JsObject, version: String): JsArray = {
  val allPatterns = json.value.collect { case (pattern, JsObject(obj)) => (pattern.replace("/", "_"), obj.filterNot { case (key, value) => key.startsWith("Supported") || key.startsWith("StyleGuide") || key.startsWith("Enabled") || key.startsWith("Description") || key.startsWith("Reference") || key.startsWith("AutoCorrect") }) }
  val codacyPatterns = allPatterns.collect { case (pattern, parameterMap) =>
    val basePattern = Json.obj(
      "patternId" -> pattern,
      "level" -> (if (pattern.startsWith("Lint") || pattern.startsWith("Metrics") || pattern.startsWith("Performance") || pattern.startsWith("Rails")) "Warning" else "Info"),
      "category" -> (if (pattern.startsWith("Lint") || (pattern.startsWith("Metrics") && !pattern.contains("Length") && !pattern.contains("AbcSize")) || pattern.startsWith("Rails")) "ErrorProne" else if (pattern.startsWith("Performance")) "Performance" else "CodeStyle")
    )
    if (parameterMap.keys.nonEmpty) {
      basePattern ++ Json.obj(
        "parameters" -> Json.parse(Json.toJson(parameterMap.map { case (key, value) => Json.obj("name" -> key, "default" -> value) }).toString).as[JsArray]
      )
    } else {
      basePattern
    }
  }
  Json.parse(Json.toJson(codacyPatterns).toString).as[JsArray]
}

def generateDescriptions(json: JsObject, ersion: String): JsArray = {
  val allPatternsWithDescs = json.value.collect { case (pattern, JsObject(obj)) => (pattern.replace("/", "_"), obj.filterNot { case (key, value) => key.startsWith("Supported") || key.startsWith("StyleGuide") || key.startsWith("Enabled") || key.startsWith("Reference") || key.startsWith("AutoCorrect") }) }
  val codacyPatternsDescs = allPatternsWithDescs.collect { case (pattern, parameterMap) if parameterMap.get("Description").isDefined =>
    val basePattern = Json.obj(
      "patternId" -> pattern,
      "title" -> parameterMap.get("Description").get,
      "description" -> parameterMap.get("Description").get,
      "timeToFix" -> 5
    )
    basePattern
  }
  Json.parse(Json.toJson(codacyPatternsDescs).toString).as[JsArray]
}
