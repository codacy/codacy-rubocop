name := "codacy-rubocop"

scalaVersion := "2.13.18"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "2.4.0",
  "com.codacy" %% "codacy-engine-scala-seed" % "6.1.5",
  "tools.jackson.dataformat" % "jackson-dataformat-yaml" % "3.2.1",
  "org.playframework" %% "play-json" % "3.1.0-M10"
)

enablePlugins(JavaAppPackaging)
