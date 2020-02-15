import org.apache.spark.{SparkContext, SparkConf}

object filter{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("filter ")                                    	  //設定名稱
val sc = new SparkContext(conf)						       //建立環境變數案例
var arr = sc.parallelize(Array(1,2,3,4,5))                             //建立資料集
val result = arr.filter(_ >= 3)                                        //進行篩選工作
result.foreach(println)                                             //列印最終結果
  }
}
