import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.clustering.PowerIterationClustering

object PIC {
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("PIC ")                              			//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = sc.textFile("c://u2.txt")								//讀取資料
    val pic = new PowerIterationClustering()						//建立私人類別
      .setK(3)												//設定聚類別數
      .setMaxIterations(20)									//設定迭代次數
    val model = pic.run(data)									//建立模型
  }
}
