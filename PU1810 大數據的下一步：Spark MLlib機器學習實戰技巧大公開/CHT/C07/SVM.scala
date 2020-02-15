import org.apache.spark.mllib.classification.SVMWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

object SVM {
  def main(args: Array[String]) {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("SVM")                              			//設定名稱
    val sc = new SparkContext(conf)                                //建立環境變數案例
    val data = sc.textFile("c:/u.txt")							  	//取得資料集路徑
    val parsedData = data.map { line =>							//開始對資料集處理
      val parts = line.split('|')									//根據逗點進行分區
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).map(_.toDouble))
    }.cache()                                                      //轉化資料格式
    val model = SVMWithSGD.train(parsedData, 10)				//訓練資料模型
    println(model.weights)									//列印權重
    println(model.intercept)									//列印截距
  }
}
