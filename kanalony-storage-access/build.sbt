import sbt.classpath.ClasspathUtilities

lazy val generateStorageAccessTask = taskKey[AnyRef]("Generates storage accessors")
lazy val `kanalony-storage-access` = (project in file(".")).
  settings(
    name := "kanalony-storage-access",
    version := "1.0",
    scalaVersion := "2.10.6",
    libraryDependencies ++= Seq(
      "com.websudos"  %% "phantom-dsl"                   % "1.12.2",
      "com.websudos"  %% "phantom-testkit"               % "1.12.2"
    ),
    resolvers ++= Seq(
      "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
      "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
      "Sonatype repo"                    at "https://oss.sonatype.org/content/groups/scala-tools/",
      "Sonatype releases"                at "https://oss.sonatype.org/content/repositories/releases",
      "Sonatype snapshots"               at "https://oss.sonatype.org/content/repositories/snapshots",
      "Sonatype staging"                 at "http://oss.sonatype.org/content/repositories/staging",
      "Java.net Maven2 Repository"       at "http://download.java.net/maven/2/",
      "Twitter Repository"               at "http://maven.twttr.com",
      "Websudos releases"                at "https://dl.bintray.com/websudos/oss-releases/"
    )
  )