import com.typesafe.sbt.packager.docker.{Cmd, ExecCmd}

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
  "com.codacy" %% "codacy-engine-scala-seed" % "2.7.0"
)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

version in Docker := "1.0"

val installAll =
  s"""apk update
     |&& apk --update add --no-cache ruby ruby-irb ruby-rake ruby-io-console ruby-bigdecimal
     |ruby-json ruby-bundler libstdc++ tzdata bash ca-certificates
     |&& echo 'gem: --no-document' > /etc/gemrc
     |&& gem install activesupport
     |&& gem install parser:2.4.0.0
     |&& gem install pry
     |&& gem install rubocop:0.48.1
     |&& gem install rubocop-migrations
     |&& gem install rubocop-rspec
     |&& gem install safe_yaml
     |&& gem cleanup
     |&& apk del build-base ruby-dev
     |&& rm -rf /var/cache/apk/*""".stripMargin.replaceAll(System.lineSeparator(), " ")

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
