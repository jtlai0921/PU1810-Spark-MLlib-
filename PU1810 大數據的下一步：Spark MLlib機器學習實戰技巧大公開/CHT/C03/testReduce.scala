import org.apache.spark.{SparkContext, SparkConf}

object testReduce {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testReduce ")                                    	  //設定名稱
val sc = new SparkContext(conf)						       //建立環境變數案例
    var str = sc.parallelize(Array("one","two","three","four","five"))          //建立資料集
    val result = str.reduce(_ + _)                                       //進行資料擬合
    result.foreach(print)                                               //列印資料結果
  }
}
