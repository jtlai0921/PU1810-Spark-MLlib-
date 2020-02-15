import org.apache.spark.mllib.feature.ChiSqSelector
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object FeatureSelection {
  def main(args: Array[String]) {
val conf = new SparkConf()                                   	//建立環境變數
.setMaster("local")                                          	//設定本機化處理
.setAppName("FeatureSelection ")                              //設定名稱
val sc = new SparkContext(conf)                               	//建立環境變數案例
    val data = MLUtils.loadLibSVMFile(sc, "c://fs.txt")				//讀取資料檔
    
    val discretizedData = data.map { lp =>						//建立資料處理空間
      LabeledPoint(lp.label, Vectors.dense(lp.features.toArray.map { x => x / 2 } ) )
    }

    val selector = new ChiSqSelector(2)					//建立選取2個特性的卡方檢驗案例
    val transformer = selector.fit(discretizedData)					//建立訓練模型
    val filteredData = discretizedData.map { lp =>					//過濾前2個特性
      LabeledPoint(lp.label, transformer.transform(lp.features))
    }

    filteredData.foreach(println)								//列印結果
  }
}


