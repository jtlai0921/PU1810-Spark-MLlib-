import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

object irisKmeans{
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("irisKmeans ")                              		//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = MLUtils.loadLibSVMFile(sc, "c://a.txt")			//輸入資料集
val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble)))
.cache()												//資料處理

    val numClusters = 3										//最大分類別數
    val numIterations = 20									//迭代次數
    val model = KMeans.train(parsedData, numClusters, numIterations)	//訓練模型
    model.clusterCenters.foreach(println)							//列印中心點座標

  }
}
