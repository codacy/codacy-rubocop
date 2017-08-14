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
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5" withSources(),
  "com.codacy" %% "codacy-engine-scala-seed" % "2.7.0",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.8.4"
)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

version in Docker := "1.0"

val filename = "src/main/resources/docs/patterns.json"

val toolMap = JSON.parseFull(Source.fromFile(filename).getLines().mkString).get.asInstanceOf[Map[String,String]]

val rubocopVersion = toolMap.get("version").map(version => s":$version").getOrElse("")

val installAll =
  s"""echo -n "" > /etc/apk/repositories
     |&& echo "http://dl-cdn.alpinelinux.org/alpine/v3.6/main" >> /etc/apk/repositories
     |&& echo "http://dl-cdn.alpinelinux.org/alpine/v3.6/community" >> /etc/apk/repositories
     |&& apk add --no-cache ruby ruby-irb ruby-rake ruby-io-console ruby-bigdecimal
     |ruby-json ruby-bundler libstdc++ tzdata bash ca-certificates libc-dev
     |&& echo 'gem: --no-document' > /etc/gemrc
     |&& gem install activesupport
     |&& gem install parser:2.4.0.0
     |&& gem install pry
     |&& gem install rubocop$rubocopVersion
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

dockerCommands := dockerCommands.value.flatMap {
  case cmd@Cmd("WORKDIR", _) => List(cmd,
    Cmd("RUN", installAll)
  )
  case cmd@(Cmd("ADD", "opt /opt")) => List(cmd,
    Cmd("RUN", "mv /opt/docker/docs /docs"),
    Cmd("RUN", s"adduser -u 2004 -D $dockerUser"),
    ExecCmd("RUN", Seq("chown", "-R", s"$dockerUser:$dockerGroup", "/docs"): _*)
  )
  case other => List(other)
}
