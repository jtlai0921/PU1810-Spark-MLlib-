import org.apache.spark.{SparkContext, SparkConf}

object distinct{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("distinct ")                                    	  //設定名稱
val sc = new SparkContext(conf)						       //建立環境變數案例
var arr = sc.parallelize(Array(("cool"), ("good"), ("bad"), ("fine"),("good"),("cool")))  //建立資料集
val result = arr.distinct()                                           //進行去重動作
result.foreach(println)                                             //列印最終結果
  }
}
