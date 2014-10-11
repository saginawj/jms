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




  }
}
