import org.apache.spark._
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.linalg.distributed.RowMatrix

object testRowMatrix {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testRowMatrix")                                    //設定名稱
    val sc = new SparkContext(conf)                                   //建立環境變數案例
    val rdd = sc.textFile("c://a.txt")                                     //建立RDD檔案路徑
      .map(_.split(' ')                                                //按“ ”分割
      .map(_.toDouble))                                             //轉成Double型態
      .map(line => Vectors.dense(line))                                //轉成Vector格式
    val rm = new RowMatrix(rdd)                                      //讀入行矩陣
    println(rm.numRows())                                           //列印列數
    println(rm.numCols())                                            //列印行數
  }
}
