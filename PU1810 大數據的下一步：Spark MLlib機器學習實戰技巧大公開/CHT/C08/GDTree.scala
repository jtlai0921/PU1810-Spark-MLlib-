import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.tree.GradientBoostedTrees
import org.apache.spark.mllib.tree.configuration.BoostingStrategy
import org.apache.spark.mllib.tree.model.GradientBoostedTreesModel
import org.apache.spark.mllib.util.MLUtils

object GDTree {

  def main(args: Array[String]) {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("GDTree")                              			//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = MLUtils.loadLibSVMFile(sc, "c://DTree.txt")				//輸入資料集

    val boostingStrategy = BoostingStrategy.defaultParams("Classification")	//建立算法型態
    boostingStrategy.numIterations = 3 							//迭代次數
    boostingStrategy.treeStrategy.numClasses = 2					//分類別數目
    boostingStrategy.treeStrategy.maxDepth = 5					//決策樹最高層數
    boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]()	//資料格式
    
val model = GradientBoostedTrees.train(data, boostingStrategy)	//訓練模型
  }
}
