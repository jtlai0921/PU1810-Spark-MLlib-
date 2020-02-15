import org.apache.spark.{SparkContext, SparkConf}

object testRDDMethod {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testRDDMethod ")                                    	  //設定名稱
    val sc = new SparkContext(conf)						      //建立環境變數案例
    val arr = sc.parallelize(Array(1,2,3,4,5,6))						  //輸入陣列資料集
    val result = arr.aggregate(0)(math.max(_, _), _ + _)				  //使用aggregate方法
    println(result)											  //列印結果
  }
}
