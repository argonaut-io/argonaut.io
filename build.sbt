organization := "io.argonaut"

name := "argonaut-doc"

val Scala211 = "2.11.8"

scalaVersion := Scala211

crossScalaVersions := Seq("2.10.6", Scala211)

libraryDependencies ++= Seq(
  "io.argonaut" %% "argonaut" % "6.1"
)
