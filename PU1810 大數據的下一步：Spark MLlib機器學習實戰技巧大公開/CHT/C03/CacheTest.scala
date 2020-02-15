import org.apache.spark.{SparkContext, SparkConf}

object CacheTest {
  def main(args: Array[String]) {
    val conf = new SparkConf()                                     //建立環境變數
      .setMaster("local")                                           //設定本機化處理
  .setAppName("CacheTest")								//設定名稱
    val sc = new SparkContext(conf)							//建立環境變數案例
    val arr = sc.parallelize(Array("abc","b","c","d","e","f"))				//設定資料集
    println(arr)												//列印結果
    println("----------------")										//分隔符
    println(arr.cache())										//列印結果
  }
}

