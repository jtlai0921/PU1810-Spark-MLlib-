import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

object irisCorrect2 {
  def main(args: Array[String]) {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("irisCorrect2")                                    //設定名稱
    val sc = new SparkContext(conf)                                //建立環境變數案例
    val dataX = sc.textFile("c://x.txt")                                //讀取資料
        .flatMap(_.split(' ')                                         //進行分割
        .map(_.toDouble))                                         //轉化為Double型態
    val dataY = sc.textFile("c://y.txt")                                 //讀取資料
      .flatMap(_.split(' ')                                            //進行分割
      .map(_.toDouble))                                           //轉化為Double型態
    val correlation: Double = Statistics.corr(dataX, dataY)         //計算不同資料之間的關聯系數
    println("setosa和versicolor中Sepal.Length的關聯系數為：" + correlation) //列印關聯系數                                      
  }
}
