name := """play-http-client"""

organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"


libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  guice,
  "org.aspectj" % "aspectjweaver" % "1.8.9",
  "org.aspectj" % "aspectjrt"     % "1.8.9",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "org.slf4j" % "slf4j-api" % "1.7.12",
  "org.postgresql" % "postgresql" % "9.4-1200-jdbc41",
  "com.google.protobuf" % "protobuf-java" % "3.5.1",
  "com.google.protobuf" % "protobuf-java-util" % "3.5.1",
  "javax.persistence" % "javax.persistence-api" % "2.2",
  "org.hibernate" % "hibernate-entitymanager" % "5.1.11.Final",
  "org.hibernate" % "hibernate-c3p0" % "5.1.11.Final",
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" % "akka-actor_2.11" % "2.5.12",
  "com.typesafe.akka" % "akka-remote_2.11" % "2.5.12",
  "com.typesafe.akka" % "akka-testkit_2.11" % "2.5.12" % "test",
  "org.webjars" % "swagger-ui" % "2.2.10-1",
  "javax.validation" % "validation-api" % "1.1.0.Final"
)

libraryDependencies ++= Seq(
  "com.marriott.rms" % "rms-jpa-utils" % "1.0-SNAPSHOT" exclude("com.typesafe.akka", "*")
).map(_.exclude("com.typesafe.akka", "*"))

jacoco.settings

jacoco.excludes        in jacoco.Config := Seq("*config*")
