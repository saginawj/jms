/**
 * Created by saginawj on 10/9/14.
 */

import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._


class  demoSparkStreaming {

  def runStream (address: String, port: Int) {

    val appName = "myClass"
    val master = "local[*]"

    println("start program")

    val conf = new SparkConf().setAppName(appName).setMaster(master)

    //SPARK STREAMING
    val ssc = new StreamingContext(conf, Seconds(10))
    val lines = ssc.socketTextStream(address, port)
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map(word => (word, 1))
    val wordcount = pairs.reduceByKey(_ + _)





    wordcount.print()
    ssc.start()
    wordcount.saveAsTextFiles("/Users/saginawj/git/jmsRepo/jms-sparkstreaming-demo/hdfs/fileOct9.txt")
    ssc.awaitTermination()
    //scala.tools.nsc.io.File("outputSpark.txt").writeAll(wordcount.toString)


  }

}
