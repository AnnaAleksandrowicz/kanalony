lazy val sparkVersion = "1.5.1"
lazy val json4sVersion = "3.2.10"
lazy val `kanalony-core` = RootProject(file("../kanalony-core"))
lazy val `kanalony-model` = (project in file(".")).
  settings(
    name := "kanalony-model",
    version := "1.0",
    scalaVersion := "2.10.6",
    libraryDependencies ++= Seq(
        "org.apache.spark"      % "spark-core_2.10"                 % sparkVersion,
        "org.json4s"            % "json4s-jackson_2.10"             % json4sVersion,
        "org.json4s"            % "json4s-native_2.10"              % json4sVersion,
        "org.json4s"            % "json4s-ext_2.10"                 % json4sVersion,
        "joda-time"             % "joda-time"                       % "2.8.1"
    )
).dependsOn(`kanalony-core`)