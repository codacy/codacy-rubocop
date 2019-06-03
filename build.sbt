import com.typesafe.sbt.packager.docker.{Cmd, ExecCmd}

import scala.io.Source
import scala.util.parsing.json.JSON

name := """codacy-engine-rubocop"""

version := "1.0-SNAPSHOT"

val languageVersion = "2.11.12"

scalaVersion := languageVersion

resolvers := Seq("Sonatype OSS Snapshots".at("https://oss.sonatype.org/content/repositories/releases"),
  "Typesafe Repo".at("http://repo.typesafe.com/typesafe/releases/")) ++ resolvers.value

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6" withSources (),
  "com.codacy" %% "codacy-engine-scala-seed" % "2.7.0",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.8.4",
  "com.typesafe.play" %% "play-ws" % "2.4.8"
)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

version in Docker := "1.0"

lazy val toolVersion = TaskKey[String](
  "The version of the underlying tool retrieved from patterns.json")

toolVersion := {
  val jsonFile = (resourceDirectory in Compile).value / "docs" / "patterns.json"
  val toolMap = JSON
    .parseFull(Source.fromFile(jsonFile).getLines().mkString)
    .getOrElse(throw new Exception("patterns.json is not a valid json"))
    .asInstanceOf[Map[String, String]]
  toolMap.getOrElse[String](
    "version",
    throw new Exception("Failed to retrieve 'version' from patterns.json"))
}

//WARNING: Update the rubocop-rspec also updates rubocop version !
def installAll(rubocopVersion: String) =
  s"""echo -n "" > /etc/apk/repositories
     |&& echo "http://dl-cdn.alpinelinux.org/alpine/v3.7/main" >> /etc/apk/repositories
     |&& echo "http://dl-cdn.alpinelinux.org/alpine/v3.7/community" >> /etc/apk/repositories
     |&& apk add --no-cache ruby-dev ruby ruby-irb ruby-rake ruby-io-console ruby-bigdecimal make gcc
     |ruby-json libstdc++ tzdata bash ca-certificates libc-dev
     |&& echo 'gem: --no-document' > /etc/gemrc
     |&& gem install bundler -v 2.0.1
     |&& cd /opt/docker/setup
     |&& bundle install
     |&& gem cleanup
     |&& apk del ruby-dev make gcc
     |&& rm -rf /tmp/* /var/cache/apk/*""".stripMargin
    .replaceAll(System.lineSeparator(), " ")

mappings in Universal <++= (resourceDirectory in Compile) map {
  resourceDir: File =>
    val src = resourceDir / "docs"
    val dest = "/docs"

    val docFiles = for {
      path <- src.***.get if !path.isDirectory
    } yield path -> path.toString.replaceFirst(src.toString, dest)

    val rubyFiles = Seq(
      (file("Gemfile"), "/setup/Gemfile"),
      (file("Gemfile.lock"), "/setup/Gemfile.lock"),
      (file(".ruby-version"), "/setup/.ruby-version"),
      (file(".rubocop-version"), "/setup/.rubocop-version")
    )

    docFiles ++ rubyFiles
}

val dockerUser = "docker"
val dockerGroup = "docker"

daemonUser in Docker := dockerUser

daemonGroup in Docker := dockerGroup

dockerBaseImage := "openjdk:8-jre-alpine"

mainClass in Compile := Some("codacy.Engine")

dockerCommands := {
  dockerCommands.dependsOn(toolVersion).value.flatMap {
    case cmd @ (Cmd("ADD", "opt /opt")) =>
      List(
        cmd,
        Cmd("RUN", installAll(toolVersion.value)),
        Cmd("RUN", "mv /opt/docker/docs /docs"),
        Cmd("RUN", s"adduser -u 2004 -D $dockerUser"),
        ExecCmd("RUN",
                Seq("chown", "-R", s"$dockerUser:$dockerGroup", "/docs"): _*)
      )
    case other => List(other)
  }
}
