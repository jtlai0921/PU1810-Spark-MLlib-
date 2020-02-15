import org.apache.spark.{SparkContext, SparkConf}

object sortBy {
  def main(args: Array[String]) {
 val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                                //設定本機化處理
.setAppName("sortBy ")                                       //設定名稱
val sc = new SparkContext(conf)						       //建立環境變數案例
    var str = sc.parallelize(Array((5,"b"),(6,"a"),(1,"f"),(3,"d"),(4,"c"),(2,"e")))  //建立資料集
    str = str.sortBy(word => word._1,true)                              //按第一個資料排序
    val str2 = str.sortBy(word => word._2,true)                          //按第二個資料排序
    str.foreach(print)                                                //列印輸出結果
    str2.foreach(print)                                               //列印輸出結果
  }
}
