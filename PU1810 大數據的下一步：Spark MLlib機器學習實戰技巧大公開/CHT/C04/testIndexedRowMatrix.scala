import org.apache.spark._
import org.apache.spark.mllib.linalg.distributed.{IndexedRow, RowMatrix, IndexedRowMatrix}
import org.apache.spark.mllib.linalg.{Vector, Vectors}

object testIndexedRowMatrix {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
setAppName("testIndexedRowMatrix")						  //設定名稱
       val sc = new SparkContext(conf)                               //建立環境變數案例
    val rdd = sc.textFile("c://a.txt")                                     //建立RDD檔案路徑
      .map(_.split(' ')                                                //按“ ”分割
      .map(_.toDouble))                                             //轉成Double型態
      .map(line => Vectors.dense(line))                               //轉化成向量儲存
      .map((vd) => new IndexedRow(vd.size,vd))                      //轉化格式
    val irm = new IndexedRowMatrix(rdd)                             //建立索引行矩陣案例
    println(irm.getClass)                                            //列印型態
    println(irm.rows.foreach(println))                                 //列印內容資料
  }
}
