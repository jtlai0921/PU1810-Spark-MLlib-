import org.apache.spark._
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.linalg.distributed.{CoordinateMatrix, MatrixEntry}

object testCoordinateRowMatrix {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testIndexedRowMatrix")						  //設定名稱
    val sc = new SparkContext(conf)                                  //建立環境變數案例
    val rdd = sc.textFile("c://a.txt")                                     //建立RDD檔案路徑
      .map(_.split(' ')                                                //按“ ”分割
      .map(_.toDouble))                                             //轉成Double型態
      .map(vue => (vue(0).toLong,vue(1).toLong,vue(2)))                //轉化成座標格式
      .map(vue2 => new MatrixEntry(vue2 _1,vue2 _2,vue2 _3))         //轉化成座標矩陣格式
    val crm = new CoordinateMatrix(rdd)                              //案例化座標矩陣
    println(crm.entries.foreach(println))                                //列印資料
  }
}
