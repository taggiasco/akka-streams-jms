name := """akka-streams-jms"""

organization := "ch.taggiasco"

version := "0.0.1"

scalaVersion := "2.12.1"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaVersion     = "2.4.17"

  Seq(
    "com.typesafe.akka"   %% "akka-stream"             % akkaVersion,
    "com.typesafe.akka"   %% "akka-stream-testkit"     % akkaVersion,
    "com.lightbend.akka"  %% "akka-stream-alpakka-jms" % "0.6",
    //"javax.jms"           %  "jms"                     % "1.1",
    "javax.jms"           %  "javax.jms-api"           % "2.0.1",
    "org.apache.activemq" %  "activemq-all"            % "5.14.1",
    "org.scalatest"       %% "scalatest"               % "3.0.1"     % "test"
  )
}
