import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

object testCorrect2 {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testCorrect2 ")                                    //設定名稱
    val sc = new SparkContext(conf)                                  //建立環境變數案例
    val rddX = sc.textFile("c://x.txt")                                   //讀取資料
        .flatMap(_.split(' ')                                           //進行分割
        .map(_.toDouble))                                           //轉化為Double型態
    val rddY = sc.textFile("c://y.txt")                                   //讀取資料
      .flatMap(_.split(' ')                                             //進行分割
      .map(_.toDouble))                                            //轉化為Double型態
    val correlation: Double = Statistics.corr(rddX, rddY，” spearman “)    //使用斯皮爾曼計算不同資料之間的關聯系數
    println(correlation)                                              //列印結果
  }
}
