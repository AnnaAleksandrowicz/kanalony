name := "kanalony-core"

version := "1.0"

scalaVersion := "2.10.6"


val sparkVersion = "1.5.1"

libraryDependencies ++= Seq(
  "org.scalatest"         % "scalatest_2.10"                  % "2.2.4"       % "test",
  "org.slf4j"             % "slf4j-api"                       % "1.7.12",
  "org.slf4j"             % "slf4j-simple"                    % "1.7.12",
  "org.apache.spark"      % "spark-core_2.10"                 % sparkVersion,
  "org.apache.spark"      % "spark-streaming_2.10"            % sparkVersion,
  "org.apache.spark"      % "spark-streaming-kafka_2.10"      % sparkVersion,
  "eu.bitwalker"          % "UserAgentUtils"                  % "1.18"
)



