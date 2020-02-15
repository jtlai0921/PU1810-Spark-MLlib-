import org.apache.spark.{SparkContext, SparkConf}

object keyBy{
  def main(args: Array[String]) {
    val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("keyBy ")                                    	  //設定名稱
val sc = new SparkContext(conf)						       //建立環境變數案例
    var str = sc.parallelize(Array("one","two","three","four","five"))          //建立資料集
    val str2 = str.keyBy(word => word.size)                              //設定組態方法
    str2.foreach(println)                                               列印結果
  }
}

