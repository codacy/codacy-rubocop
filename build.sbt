import com.typesafe.sbt.packager.docker.{Cmd, ExecCmd}
import scala.util.parsing.json.JSON
import scala.io.Source

name := """codacy-engine-rubocop"""

version := "1.0-SNAPSHOT"

val languageVersion = "2.11.8"

scalaVersion := languageVersion

resolvers ++= Seq(
  "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6" withSources(),
  "com.codacy" %% "codacy-engine-scala-seed" % "2.7.0",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.8.4",
  "com.typesafe.play" %% "play-ws" % "2.4.8"
)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

version in Docker := "1.0"

lazy val toolVersion = TaskKey[String]("The version of the underlying tool retrieved from patterns.json")

toolVersion := {
  val jsonFile = (resourceDirectory in Compile).value / "docs" / "patterns.json"
  val toolMap = JSON.parseFull(Source.fromFile(jsonFile).getLines().mkString)
    .getOrElse(throw new Exception("patterns.json is not a valid json"))
    .asInstanceOf[Map[String, String]]
  toolMap.getOrElse[String]("version", throw new Exception("Failed to retrieve 'version' from patterns.json"))
}

def installAll(rubocopVersion: String) =
  s"""echo -n "" > /etc/apk/repositories
     |&& echo "http://dl-cdn.alpinelinux.org/alpine/v3.6/main" >> /etc/apk/repositories
     |&& echo "http://dl-cdn.alpinelinux.org/alpine/v3.6/community" >> /etc/apk/repositories
     |&& apk add --no-cache ruby ruby-irb ruby-rake ruby-io-console ruby-bigdecimal
     |ruby-json ruby-bundler libstdc++ tzdata bash ca-certificates libc-dev
     |&& echo 'gem: --no-document' > /etc/gemrc
     |&& gem install activesupport
     |&& gem install parser:2.4.0.0
     |&& gem install pry
     |&& gem install rubocop:$rubocopVersion
     |&& gem install rubocop-migrations
     |&& gem install rubocop-rspec
     |&& gem install lingohub-rubocop
     |&& gem install safe_yaml
     |&& gem cleanup
     |&& rm -rf /tmp/* /var/cache/apk/*""".stripMargin.replaceAll(System.lineSeparator(), " ")

mappings in Universal <++= (resourceDirectory in Compile) map { (resourceDir: File) =>
  val src = resourceDir / "docs"
  val dest = "/docs"

  for {
    path <- (src ***).get
    if !path.isDirectory
  } yield path -> path.toString.replaceFirst(src.toString, dest)
}

val dockerUser = "docker"
val dockerGroup = "docker"

daemonUser in Docker := dockerUser

daemonGroup in Docker := dockerGroup

dockerBaseImage := "develar/java"

mainClass in Compile := Some("codacy.Engine")

dockerCommands := {
  dockerCommands.dependsOn(toolVersion).value.flatMap {
    case cmd@Cmd("WORKDIR", _) => List(cmd,
      Cmd("RUN", installAll(toolVersion.value))
    )
    case cmd@(Cmd("ADD", "opt /opt")) => List(cmd,
      Cmd("RUN", "mv /opt/docker/docs /docs"),
      Cmd("RUN", s"adduser -u 2004 -D $dockerUser"),
      ExecCmd("RUN", Seq("chown", "-R", s"$dockerUser:$dockerGroup", "/docs"): _*)
    )
    case other => List(other)
  }
}
