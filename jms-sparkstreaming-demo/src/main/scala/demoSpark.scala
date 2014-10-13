/**
 * Created by saginawj on 10/9/14.
 */



import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._


class demoSpark {


def runSpark {

  val appName = "myClass"
  val master = "local[*]"
  val conf = new SparkConf().setAppName(appName).setMaster(master)

  val sc =  new SparkContext(conf)
  val file = sc.textFile("text.txt")
  val wordCount = file.flatMap(_.split(" ")).map(_ -> 1).reduceByKey(_ + _)
  println("Row Count: " + file.count())
  println("Word Count: " + wordCount.count())
  println("Popular Words:")
  wordCount.map(_.swap).sortByKey(false).take(5).foreach(println)

  }




}
