organization := "io.metabookmarks"

name := "akka-http-demo"

version := "1.0"

scalaVersion := "2.12.2"

val akkaVersion = "2.5.3"
val akkaHttpVersion = "10.0.9"
val circeVersion = "0.8.0"


javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint", "-Xlog-implicits")

scalacOptions := Seq("-deprecation", "-feature", "-language:postfixOps")

libraryDependencies += "com.typesafe.akka" %% "akka-http" % akkaHttpVersion exclude( "org.slf4j", "slf4j-log4j12" )

libraryDependencies ++= Seq(
  "circe-core",
  "circe-generic",
  "circe-parser"
).map(d => "io.circe" %% d % circeVersion)

libraryDependencies += "de.heikoseeberger" %% "akka-http-circe" % "1.17.0"

libraryDependencies += "com.typesafe" % "config" % "1.3.1"

libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.25"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.3" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")






