organization := "io.argonaut"

name := "argonaut-doc"

scalaVersion := "2.10.1"

crossScalaVersions := Seq("2.9.2", "2.9.3", "2.10.1")

libraryDependencies ++= Seq(
  "io.argonaut" %% "argonaut" % "6.0-RC2"
)
