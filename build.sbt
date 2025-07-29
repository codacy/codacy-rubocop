name := "codacy-rubocop"

scalaVersion := "2.13.16"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "2.4.0",
  "com.codacy" %% "codacy-engine-scala-seed" % "6.1.5",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.19.2",
  "org.playframework" %% "play-json" % "3.0.5"
)

enablePlugins(JavaAppPackaging)
