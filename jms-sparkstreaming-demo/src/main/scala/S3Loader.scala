/**
 * Created by saginawj on 10/10/14.
 */

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.auth.BasicAWSCredentials
import java.io.File
//import play.api._

object S3Loader extends App{

  val bucketName = "jmsstreamdata"

  val fileToUpload = new File("/Users/saginawj/AWS/data/volcano.jpg")

  val fileName = "Volcano"

  val AWS_ACCESS_KEY = "AKIAJTPVS6BXSOXORKPA"
  val AWS_SECRET_KEY = "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"

  val awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY,AWS_SECRET_KEY)

  val s3Client = new AmazonS3Client(awsCreds)

 // s3Client.createBucket(bucketName)

  s3Client.putObject(bucketName, fileName, fileToUpload)

  print("Uploaded " + fileName + " to " + bucketName)






}
