name := "callsign_coding_exercise"

version := "0.1"

scalaVersion := "2.11.8"

val sparkVersion = "2.4.4"
val specs2Version = "4.2.0"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.4.0" % "provided",
  "com.github.pureconfig" % "pureconfig_2.11" % "0.12.2"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.2" % "test"