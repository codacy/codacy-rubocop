name := "codacy-rubocop"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
  "com.codacy" %% "codacy-engine-scala-seed" % "5.0.3",
  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.12.1",
  "com.typesafe.play" %% "play-json" % "2.8.1"
)

enablePlugins(JavaAppPackaging)
