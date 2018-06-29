organization := "io.argonaut"

name := "argonaut-doc"

val Scala211 = "2.11.12"

scalaVersion := Scala211

crossScalaVersions := Seq(Scala211)

val argonautVersion = "6.2.2"

libraryDependencies ++= Seq(
  "io.argonaut" %% "argonaut" % argonautVersion,
  "io.argonaut" %% "argonaut-scalaz" % argonautVersion,
  "io.argonaut" %% "argonaut-cats" % argonautVersion,
  "io.argonaut" %% "argonaut-monocle" % argonautVersion
)
