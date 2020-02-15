import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.mllib.util.MLUtils

object irisRFDTree {
  def main(args: Array[String]) {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("irisRFDTree")                              		//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = MLUtils.loadLibSVMFile(sc, "c://a.txt")				//輸入資料集
    
val numClasses = 3										//設定分類別的數量
    val categoricalFeaturesInfo = Map[Int, Int]()					//設定輸入資料格式
    val numTrees = 3 								   //設定隨機雨林中決策樹的數目
val featureSubsetStrategy = "auto"							//設定屬性在節點計算數
val impurity = "entropy"									//設定訊息增益計算模式
    val maxDepth = 5										//設定樹高度	
    val maxBins = 3											//設定分裂資料集

    val model = RandomForest.trainClassifier(data, numClasses, categoricalFeaturesInfo,
      numTrees, featureSubsetStrategy, impurity, maxDepth, maxBins)	//建立模型

    model.trees.foreach(println)								//列印每棵樹的相信訊息
  }
}
