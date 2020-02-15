import org.apache.spark.{SparkContext, SparkConf}

object Cartesian{
  def main(args: Array[String]) {
val conf = new SparkConf()                                        //建立環境變數
.setMaster("local")                                                //設定本機化處理
.setAppName("Cartesian ")                                    	   //設定名稱
    val sc = new SparkContext(conf)						       //建立環境變數案例
    var arr = sc.parallelize(Array(1,2,3,4,5,6))						  //建立第一個陣列
    var arr2 = sc.parallelize(Array(6,5,4,3,2,1))						  //建立第二個資料
    val result = arr.cartesian(arr2)                                     //進行笛卡爾計算
    result.foreach(print)                                              //列印結果
  }
}
