import org.apache.spark.mllib.feature.Word2Vec
import org.apache.spark.{SparkConf, SparkContext}

object word2Vec {
  def main(args: Array[String]) {
val conf = new SparkConf()                                   	//建立環境變數
.setMaster("local")                                          	//設定本機化處理
.setAppName("word2Vec ")                                    		//設定名稱
val sc = new SparkContext(conf)                               	//建立環境變數案例
    val documents = sc.textFile("c://a.txt").map(_.split(" ").toSeq)		//讀取資料檔

    val word2vec = new Word2Vec()							//建立詞向量案例
    val model = word2vec.fit(data)								//訓練模型
    println(model.getVectors)  								//列印向量模型
val synonyms = model.findSynonyms("spar", 2)					//尋找spar的相似詞
    for(synonym <- synonyms){								//列印找到的內容
      println(synonym)
    }
  }
}


