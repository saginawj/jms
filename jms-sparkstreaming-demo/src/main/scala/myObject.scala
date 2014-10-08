/**
 * Created by saginawj on 10/8/14.
 */

import org.apache.spark._
import org.apache.spark.streaming._

object myObject {

  def main(args:Array[String]): Unit = {

    println("start this")

    val appName = "myClass"
    val master = "master"

    //here are comments i added
    val conf = new SparkConf().setAppName(appName).setMaster(master)
    val ssc =  new StreamingContext(conf, Seconds(1))

    println("end this")


  }

}
