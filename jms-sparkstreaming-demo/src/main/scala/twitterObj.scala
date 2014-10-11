import org.apache.spark.streaming.StreamingContext
import twitter4j.conf.ConfigurationBuilder

/**
 * Created by saginawj on 10/10/14.
 */
import org.apache.spark.streaming.{ Seconds, StreamingContext }
import StreamingContext._
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.twitter._
import org.apache.spark.SparkConf
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken

object twitterObj extends App {

  println("start app")
  val consumerKey = "7cWNylncLdqv1V4N3GoocpE93"
  val consumerSecret = "AVoUOBxEdxm55iqfOtiQCjHABCcdDBuHl7Mi41vGBTO9pea1XF"
  val accessToken = "187902348-FPc6JaPXCe36jS5OmmhCDC3hH8mqu6Yv3nWLnVVM"
  val accessTokenSecret = "RZO4JTK9uTNZ7K4FV9Nr3M3uH8oSBDeyk1h3sk7XnHJzS"

  //file
  val twitter = new TwitterFactory().getInstance()
  twitter.setOAuthConsumer(consumerKey, consumerSecret)
  twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret))

  val filters = Seq("the")

  val conf = new SparkConf(false)
    .setMaster("local[4]")
    .setAppName("TestTwitter")
  val ssc = new StreamingContext(conf, Seconds(2))
  val stream = TwitterUtils.createStream(ssc, Option(twitter.getAuthorization()), filters)
  println("all created")

  val hashTags = stream.flatMap(status => status.getText.split(" ").filter(_.startsWith("#")))
  println("i have my hash")

 // twitter.trends()



  /*
  println("HashTags Count: ") + hashTags.count().toString()

  hashTags.print()



  val topCounts10 = hashTags.map((_, 1)).reduceByKeyAndWindow(_ + _, Seconds(10))
    .map { case (topic, count) => (count, topic) }
    .transform(_.sortByKey(false))

  topCounts10.foreachRDD(rdd => {
    val topList = rdd.take(5)
    println("stop here")
    println("\nPopular topics in last 10 seconds (%s total):".format(rdd.count()))
    topList.foreach { case (count, tag) => println("%s (%s tweets)".format(tag, count)) }
  })
  */

  ssc.start()
  ssc.awaitTermination()


}
