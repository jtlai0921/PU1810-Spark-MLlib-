import org.apache.spark.mllib.clustering.GaussianMixture
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

object irisGMG {
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("irisGMG")                              			//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = sc.textFile("c://a.txt")							//輸入數個
val parsedData = data.map(s => Vectors.dense(s.trim.split(' ')		//轉化資料格式
.map(_.toDouble))).cache()
    val model = new GaussianMixture().setK(2).run(parsedData)		//訓練模型

    for (i <- 0 until model.k) {
      println("weight=%f\nmu=%s\nsigma=\n%s\n" format			//一個一個列印單一模型
        (model.weights(i), model.gaussians(i).mu, model.gaussians(i).sigma))	//列印結果
    }
  }
}
