import com.typesafe.sbt.packager.docker.Cmd
import sjsonnew.BasicJsonProtocol._
import sjsonnew._
import sjsonnew.support.scalajson.unsafe._

name := "codacy-rubocop"

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.2.0" withSources (),
  "com.codacy" %% "codacy-engine-scala-seed" % "5.0.1",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.8.4",
  "com.typesafe.play" %% "play-json" % "2.8.1"
)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

lazy val toolVersion = settingKey[String]("The version of the underlying tool retrieved from patterns.json")

toolVersion := {
  case class Patterns(name: String, version: String)
  implicit val patternsIso: IsoLList[Patterns] =
    LList.isoCurried((p: Patterns) => ("name", p.name) :*: ("version", p.version) :*: LNil) {
      case (_, n) :*: (_, v) :*: LNil => Patterns(n, v)
    }

  val jsonFile = (resourceDirectory in Compile).value / "docs" / "patterns.json"
  val json = Parser.parseFromFile(jsonFile)
  val patterns = json.flatMap(Converter.fromJson[Patterns])
  patterns.get.version
}

mappings in Universal ++= (resourceDirectory in Compile).map { resourceDir: File =>
  val src = resourceDir / "docs"
  val dest = "/docs"

  for {
    path <- src.allPaths.get if !path.isDirectory
  } yield path -> path.toString.replaceFirst(src.toString, dest)
}.value

val dockerUser = "docker"
val dockerGroup = "docker"

daemonUser in Docker := dockerUser
daemonGroup in Docker := dockerGroup

dockerBaseImage := "codacy-rubocop-base"

mappings in Universal += file("scripts/doc_generate.sh") -> "scripts/doc_generate.sh"
mappings in Universal += file("Gemfile") -> "Gemfile"
mappings in Universal += file("doc_generation/codacy/rubocop/generator.rb") -> "doc_generation/codacy/rubocop/generator.rb"
mappings in Universal += file("doc_generation/rubocop_doc/generator.rb") -> "doc_generation/rubocop_doc/generator.rb"

dockerCommands := {
  dockerCommands.value.flatMap {
    case cmd @ (Cmd("ADD", _)) =>
      Seq(
        Cmd("RUN", s"adduser -u 2004 -D $dockerUser"),
        cmd,
        Cmd("RUN", "sh scripts/doc_generate.sh $PWD"),
        Cmd("RUN", "apk del ruby-dev make gcc"),
        Cmd("RUN", "mv /opt/docker/docs /docs")
      )
    case other => Seq(other)
  }
}
