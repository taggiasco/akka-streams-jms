name := """akka-streams-jms"""

organization := "ch.taggiasco"

version := "0.0.2"

scalaVersion := "2.12.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaVersion       = "2.4.19"
  val alpakkaJmsVersion = "0.11"

  Seq(
    "com.typesafe.akka"   %% "akka-stream"             % akkaVersion,
    "com.typesafe.akka"   %% "akka-stream-testkit"     % akkaVersion,
    "com.lightbend.akka"  %% "akka-stream-alpakka-jms" % alpakkaJmsVersion,
    //"javax.jms"           %  "jms"                     % "1.1",
    "javax.jms"           %  "javax.jms-api"           % "2.0.1",
    "org.apache.activemq" %  "activemq-all"            % "5.14.1",
    "org.scalatest"       %% "scalatest"               % "3.0.1"     % "test"
  )
}
