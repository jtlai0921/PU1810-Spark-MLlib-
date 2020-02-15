import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object LogisticRegression2 {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("LogisticRegression2 ")                              //設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例

  def main(args: Array[String]) {
    val data = MLUtils.loadLibSVMFile(sc, "c://sample_libsvm_data.txt")	//讀取資料檔
val model = LogisticRegressionWithSGD.train(data,50)			//訓練資料模型
println(model.weights.size)								//列印θ值
println(model.weights)									//列印θ值個數
    println(model.weights.toArray.filter(_ != 0).size)					//列印θ中不為0的數
  }
}
