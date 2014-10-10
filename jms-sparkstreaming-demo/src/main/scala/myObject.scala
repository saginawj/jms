/**
 * Created by saginawj on 10/8/14.
 */

import java.io.PrintWriter

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{Path, FileSystem}

object myObject {

  def main(args:Array[String]): Unit = {

    //nc -lk 9999
    val address = "localhost"
    val port = 9999

    //execute streaming
    val demoStream = new demoSparkStreaming()
    demoStream.runStream(address, port)


    //val demoSpark = new demoSpark()
    // demoSpark.runSpark


    /*
    //HDFS Test
    val conf = new Configuration()
    val fs= FileSystem.get(conf)
    val output = fs.create(new Path("/your/path"))
    val writer = new PrintWriter(output)
    try {
      writer.write(firstRow)
      writer.write("\n")
      writer.write(restData)
    }
    finally {
      writer.close()
    }

    */

  }
}
