name := "codacy-rubocop"

scalaVersion := "2.13.16"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "2.3.0",
  "com.codacy" %% "codacy-engine-scala-seed" % "6.1.2",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.17.1",
  "com.typesafe.play" %% "play-json" % "2.8.1"
)

enablePlugins(JavaAppPackaging)
