import org.apache.spark.mllib.feature.{IDF, HashingTF}
import org.apache.spark.{SparkContext, SparkConf}

object TF_IDF {
  def main(args: Array[String]) {
val conf = new SparkConf()                                   	//建立環境變數
.setMaster("local")                                          	//設定本機化處理
.setAppName("TF_IDF ")                                    		//設定名稱
val sc = new SparkContext(conf)                               	//建立環境變數案例
    val documents = sc.textFile("c://a.txt").map(_.split(" ").toSeq)		//讀取資料檔

    val hashingTF = new HashingTF()							//首先建立TF計算案例
    val tf = hashingTF.transform(documents).cache()				//計算文件TF值
    val idf = new IDF().fit(tf)									//建立IDF案例並計算

    val tf_idf= idf.transform(tf)									//計算TF_IDF詞頻
    tf_idf.foreach(println)										//列印結果

  }
}
