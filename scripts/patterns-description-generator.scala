import com.fasterxml.jackson.core.JsonParser.Feature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import play.api.libs.json._

def updatePatternsAndDescription(version: String): Unit = {
  def yamlReader: ObjectMapper = new ObjectMapper(new YAMLFactory()).configure(Feature.ALLOW_COMMENTS, true).configure(Feature.AUTO_CLOSE_SOURCE, true).configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).configure(Feature.ALLOW_SINGLE_QUOTES, true).configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true)

  val cops = scala.io.Source.fromFile(new java.io.File(s"rubocop-config-base-files/$version.yml")).getLines.toList.mkString("\n")
  val json = Json.parse(yamlReader.readTree(cops).toString).as[JsObject]
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
  val allPatternsWithDescs = json.value.collect { case (pattern, JsObject(obj)) => (pattern.replace("/", "_"), obj.filterNot { case (key, value) => key.startsWith("Supported") || key.startsWith("StyleGuide") || key.startsWith("Enabled") || key.startsWith("Reference") || key.startsWith("AutoCorrect") }) }
  val codacyPatternsDescs = allPatternsWithDescs.collect { case (pattern, parameterMap) if parameterMap.get("Description").isDefined =>
    val filteredPatMap = parameterMap.filterNot { case (pattern, _) => pattern == "Description" }
    val basePattern = Json.obj(
      "patternId" -> pattern,
      "title" -> parameterMap.get("Description").get,
      "description" -> parameterMap.get("Description").get,
      "timeToFix" -> 5
    )
    if (filteredPatMap.keys.nonEmpty) {
      basePattern ++ Json.obj(
        "parameters" -> Json.parse(Json.toJson(filteredPatMap.map { case (key, value) => Json.obj("name" -> key, "description" -> "<TODO: parameter description>") }).toString).as[JsArray]
      )
    } else {
      basePattern
    }
  }
  println(Json.obj("name" -> "Rubocop", "version" -> version, "patterns" -> Json.parse(Json.toJson(codacyPatterns).toString).as[JsArray]))
  println("\n\n")
  println(Json.parse(Json.toJson(codacyPatternsDescs).toString).as[JsArray])
  println("\n\n")
  println("NOTE: Look for '<TODO: parameter description>' on the descriptions .json, and fix them accordingly")
}
