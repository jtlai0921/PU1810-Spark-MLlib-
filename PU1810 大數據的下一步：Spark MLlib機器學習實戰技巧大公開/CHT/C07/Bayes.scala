import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

object Bayes {
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("Bayes ")                              			//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = MLUtils.loadLabeledPoints(sc,"c://bayes.txt")			//讀取資料集
    val model = NaiveBayes.train(data, 1.0)						//訓練貝葉斯模型
    model.labels.foreach(println)								//列印label值
model.pi.foreach(println)									//列印先驗機率  
}	
}
