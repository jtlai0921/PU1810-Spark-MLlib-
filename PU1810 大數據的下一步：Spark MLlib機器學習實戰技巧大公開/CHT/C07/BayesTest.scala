import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

object Bayes {

  def main(args: Array[String]) {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("BayesTest ")                              			//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = MLUtils.loadLabeledPoints(sc,"c://data.txt")			//讀取資料集
    val data = file.map { line =>								//處理資料
      val parts = line.split(',')									//分割資料
      LabeledPoint(parts(0).toDouble, 							//標簽資料轉換
Vectors.dense(parts(1).split(' ').map(_.toDouble)))				//向量資料轉換
    }

    val splits = data.randomSplit(Array(0.7, 0.3), seed = 11L)			//對資料進行分配
    val trainingData = splits(0)									//設定訓練資料
    val testData = splits(1)									//設定測試資料
    val model = NaiveBayes.train(trainingData, lambda = 1.0)			//訓練貝葉斯模型
    val predictionAndLabel = testData.map(p => (model.predict(p.features), p.label)) //驗證模型
    val accuracy = 1.0 * predictionAndLabel.filter(					//計算準確度
      label => label._1 == label._2).count()						//比較結果
    println(accuracy)										//列印準確度
  }
}

