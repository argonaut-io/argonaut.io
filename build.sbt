organization := "io.argonaut"

name := "argonaut-doc"

val Scala211 = "2.11.9"

scalaVersion := Scala211

crossScalaVersions := Seq(Scala211)

libraryDependencies ++= Seq(
  "io.argonaut" %% "argonaut" % "6.2",
  "io.argonaut" %% "argonaut-scalaz" % "6.2",
  "io.argonaut" %% "argonaut-cats" % "6.2",
  "io.argonaut" %% "argonaut-monocle" % "6.2"
)
