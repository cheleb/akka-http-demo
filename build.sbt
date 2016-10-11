organization := "io.metabookmarks"

name := "akka-http-demo"

version := "1.0"

scalaVersion := "2.11.8"

val akkaVersion = "2.4.11"
val circeVersion = "0.5.2"


javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint", "-Xlog-implicits")

scalacOptions := Seq("-deprecation", "-feature", "-language:postfixOps")

libraryDependencies += "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion exclude( "org.slf4j", "slf4j-log4j12" )

libraryDependencies ++= Seq(
  "circe-core",
  "circe-generic",
  "circe-parser"
).map(d => "io.circe" %% d % circeVersion)

libraryDependencies += "de.heikoseeberger" %% "akka-http-circe" % "1.10.1"

libraryDependencies += "com.typesafe" % "config" % "1.2.1"

libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.21"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.0" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")






