lazy val sparkVersion = "1.6.0"
lazy val `kanalony-model` = RootProject(file("../kanalony-model"))
lazy val `kanalony-core` = RootProject(file("../kanalony-core"))
lazy val `kanalony-aggregations` = (project in file(".")).
  settings(
    name := "kanalony-aggregations",
    version := "1.0",
    scalaVersion := "2.10.6",
    resolvers += Resolver.jcenterRepo,
    libraryDependencies ++= Seq(
      "org.clapper"           %% "classutil"                  % "1.0.6",
      "org.apache.spark"      %% "spark-core"                 % sparkVersion,
      "org.apache.spark"      %% "spark-streaming"            % sparkVersion,
      "org.apache.spark"      %% "spark-streaming-kafka"      % sparkVersion,
      "com.datastax.spark"    %% "spark-cassandra-connector"  % "1.4.0",
      "joda-time"             % "joda-time"                   % "2.8.2",
      // Test
      "org.scalatest"         %% "scalatest"                  % "2.2.4"    % "test"
    )
  ).dependsOn(`kanalony-model`, `kanalony-core`)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

