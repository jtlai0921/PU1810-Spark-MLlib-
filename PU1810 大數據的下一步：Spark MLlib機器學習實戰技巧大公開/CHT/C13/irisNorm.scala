import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

object irisNorm{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("irisNorm")                                         //設定名稱
    val sc = new SparkContext(conf)                                   //建立環境變數案例
    val data = sc.textFile("c:// Sepal.Length_setosa.txt")                   //建立RDD檔案路徑
.map(_.toDouble))                                              //轉成Double型態
      .map(line => Vectors.dense(line))                                 //轉成Vector格式
val summary = Statistics.colStats(data)						   //計算統計量
    println("setosa中Sepal的曼哈頓距離的值為：" + summary.normL1)	   //計算曼哈頓距離
    println("setosa中Sepal的歐幾裡得距離的值為：" + summary.normL2)  //計算歐幾裡得距離
  }
}
