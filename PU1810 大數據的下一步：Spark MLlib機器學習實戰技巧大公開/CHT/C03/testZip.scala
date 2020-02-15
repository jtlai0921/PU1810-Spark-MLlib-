import org.apache.spark.{SparkContext, SparkConf}

object testZip{
  def main(args: Array[String]) {
val conf = new SparkConf()                                        //建立環境變數
.setMaster("local")                                                //設定本機化處理
.setAppName("testZip")                                       //設定名稱
val sc = new SparkContext(conf)						       //建立環境變數案例
    val arr1 = Array(1,2,3,4,5,6)							       //建立資料集1
    val arr2 = Array("a","b","c","d","e","f")                                //建立資料集1
    val arr3 = Array("g","h","i","j","k","l")                                 //建立資料集1
    val arr4 = arr1.zip(arr2).zip(arr3)                                   //進行亞述算法
    arr4.foreach(print)                                               //列印結果
  }
}
