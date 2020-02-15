import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

object irisALL{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("irisAll ")                                          //設定名稱
    val sc = new SparkContext(conf)                                  //建立環境變數案例
    val data = sc.textFile("c:// Sepal.Length.txt")                        //建立RDD檔案路徑
.map(_.toDouble))                                             //轉成Double型態
      .map(line => Vectors.dense(line))                                //轉成Vector格式
val summary = Statistics.colStats(data)						  //計算統計量
println("全部Sepal.Length的均值為：" + summary.mean)		      //列印均值
println("全部Sepal.Length的方差為：" + summary.variance)	      //列印方差
  }
}
