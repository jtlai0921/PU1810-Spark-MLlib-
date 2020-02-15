import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.evaluation.MulticlassMetrics

object LinearRegression3{
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("LogisticRegression3")                              //設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例

  def main(args: Array[String]) {
    val data = MLUtils.loadLibSVMFile(sc, "c://sample_libsvm_data.txt")	//讀取資料集
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)			//對資料集切分
    val parsedData = splits(0)									//分割訓練資料
    val parseTtest = splits(1)									//分割測試資料
    val model = LogisticRegressionWithSGD.train(parsedData,50)		//訓練模型
    println(model.weights)									//列印θ值
   val predictionAndLabels = parseTtest.map { 					//計算測試值
case LabeledPoint(label, features) =>						//計算測試值
 val prediction = model.predict(features)						//計算測試值
      (prediction, label)										//儲存測試和預測值
    }
    val metrics = new MulticlassMetrics(predictionAndLabels)			//建立驗證類別
    val precision = metrics.precision								//計算驗證值
    println("Precision = " + precision)							//列印驗證值
  }
}
