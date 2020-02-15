import org.apache.spark.{SparkContext, SparkConf}

object groupBy{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("groupBy ")                                    	  //設定名稱
val sc = new SparkContext(conf)						       //建立環境變數案例
var arr = sc.parallelize(Array(1,2,3,4,5))                             //建立資料集
    arr.groupBy(myFilter(_), 1)									   //設定第一個分群組
    arr.groupBy(myFilter2(_), 2)								   //設定第二個分群組
  }

  def myFilter(num: Int): Unit = {								   //自訂方法
    num >= 3                                                        //條件
  }
  def myFilter2(num: Int): Unit = {								   //自訂方法
    num < 3                                                         //條件
  }

}
