import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

object irisBayes {
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("irisBayes")                              		//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = MLUtils.loadLabeledPoints(sc,"c://a.txt")				//讀取資料集
    val model = NaiveBayes.train(data, 1.0)						//訓練貝葉斯模型
val test = Vectors.dense(7.3,2.9,6.3,1.8)						//建立待測定資料
val result = model.predict(“測試資料歸屬在類別別:” + test)			//列印結果
}	
}
