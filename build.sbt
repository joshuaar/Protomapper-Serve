name := "Protomapper-Serve"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings

scalaVersion := "2.10.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Apache Snapshots" at "http://repository.apache.org/snapshots/"

resolvers += "Biojava repository" at "http://www.biojava.org/download/maven/"

libraryDependencies += "org.scalatra" %% "scalatra" % "2.2.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"   % "2.2-M3",
  "com.typesafe.akka" %% "akka-slf4j"   % "2.2-M3",
  "com.typesafe.akka" %% "akka-remote"  % "2.2-M3",
  "com.typesafe.akka" %% "akka-agent"   % "2.2-M3",
  "com.typesafe.akka" %% "akka-testkit" % "2.2-M3" % "test",
  "org.apache.lucene" % "lucene-core" % "4.0-SNAPSHOT",
  "org.apache.lucene" % "lucene-analyzers-common" % "4.0-SNAPSHOT",
  "org.apache.lucene" % "lucene-queryparser" % "4.0-SNAPSHOT",
  "org.biojava" % "biojava3-core" % "3.0.7",
  "org.scalatest" % "scalatest_2.10" % "1.9.2"  
)
