import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/**
 * Created by saginawj on 10/11/14.
 */

object sparkJobs extends App {

  val sc = new SparkContext("local", "Word Count (2)")

  try {

    val input = sc.textFile("/Users/saginawj/data/kingjames.txt").map(line => line.toLowerCase)
    input.cache

    val wc = input
      .flatMap(line => line.split("""\W+"""))
      .map(word => (word, 1))
      .reduceByKey((count1, count2) => count1 + count2)

    val now = System.currentTimeMillis()
    val out = s"output/kjv-wc2-$now"
    println(s"Writing output to: $out")
    wc.saveAsTextFile(out)


    val wordCount = input.flatMap(_.split(" ")).map(_ -> 1).reduceByKey(_ + _)
    println("Row Count: " + input.count())
    println("Word Count: " + wordCount.count())
    println("Popular Words:")
    wordCount.map(_.swap).sortByKey(false).take(5).foreach(println)


  } finally {
    sc.stop()      // Stop (shut down) the context.
  }

}
