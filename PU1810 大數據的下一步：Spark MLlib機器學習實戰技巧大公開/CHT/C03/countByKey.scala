import org.apache.spark.{SparkContext, SparkConf}

object countByKey{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("countByKey ")                                    	  //設定名稱
    val sc = new SparkContext(conf)						       //建立環境變數案例
    var arr = sc.parallelize(Array((1, "cool"), (2, "good"), (1, "bad"), (1, "fine")))  //建立資料集
    val result = arr.countByKey()                                      //進行計數
    result.foreach(print)                                              //列印結果
  }
}
