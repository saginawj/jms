name := "jms-sparkstreaming-demo"

version := "1.0"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.1.0"

libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.10" % "1.1.0"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

//libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.1"

libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.0.002"

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "[2.2,)"