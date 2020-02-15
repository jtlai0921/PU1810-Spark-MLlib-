import org.apache.spark.{SparkContext, SparkConf}

object Coalesce{
  def main(args: Array[String]) {
val conf = new SparkConf()                                        //建立環境變數
.setMaster("local")                                                //設定本機化處理
.setAppName("Coalesce ")                                    	   //設定名稱
    val sc = new SparkContext(conf)						       //建立環境變數案例
    val arr = sc.parallelize(Array(1,2,3,4,5,6))						  //建立資料集
    val arr2 = arr.coalesce(2,true)                                     //將資料重新分區
    val result = arr.aggregate(0)(math.max(_, _), _ + _)                  //計算資料值
    println(result)                                                   //列印結果
    val result2 = arr2.aggregate(0)(math.max(_, _), _ + _)               //計算重新分區資料值
    println(result2)  }                                               //列印結果
}
