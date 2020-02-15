import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils

object DT {
  def main(args: Array[String]) {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("DT")                              			//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = MLUtils.loadLibSVMFile(sc, "c://DTree.txt")				//輸入資料集

    val numClasses = 2 										//設定分類別數量
    val categoricalFeaturesInfo = Map[Int, Int]()					//設定輸入格式
    val impurity = "entropy"									//設定訊息增益計算模式
    val maxDepth = 5										//設定樹高度	
    val maxBins = 3											//設定分裂資料集

    val model = DecisionTree.trainClassifier(data, numClasses, categoricalFeaturesInfo,
      impurity, maxDepth, maxBins)								//建立模型
    println(model.topNode)									//列印決策樹訊息

  }
}
