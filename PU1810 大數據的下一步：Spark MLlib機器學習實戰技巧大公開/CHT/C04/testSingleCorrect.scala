import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

object testSingleCorrect {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testSingleCorrect ")                                //設定名稱
    val sc = new SparkContext(conf)                                  //建立環境變數案例
val rdd = sc.textFile("c://x.txt")                                    //讀取資料檔
      .map(_.split(' ')                                               //切割資料
      .map(_.toDouble))                                            //轉化為Double型態
      .map(line => Vectors.dense(line))                               //轉為向量
println(Statistics.corr(rdd,"spearman"))                            //使用斯皮爾曼計算關聯系數
}
}
