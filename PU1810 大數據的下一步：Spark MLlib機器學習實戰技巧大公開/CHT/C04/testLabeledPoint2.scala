import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark._
import org.apache.spark.mllib.util.MLUtils

object testLabeledPoint2 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("SparkPi")//建立本機環境變數    
val sc = new SparkContext(conf)                                 //建立Spark處理

    val mu = MLUtils.loadLibSVMFile(sc, "c://a.txt")                    //從C路徑碟讀取檔案
mu.foreach(println)                                             //列印內容
	}                               
}
