import org.apache.spark.{SparkContext, SparkConf}

object testRDDMethod {
  def main(args: Array[String]) {
 val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testRDDMethod ")                                    	  //設定名稱
val sc = new SparkContext(conf)						       //建立環境變數案例
    var str = sc.parallelize(Array("one","two","three","four","five"))          //建立資料集
    val result = str.reduce(myFun)								  //進行資料擬合
    result.foreach(print)                                              //列印結果
  }
  
  def myFun(str1:String,str2:String):String = {                          //建立方法
    var str = str1                                                   //設定確定方法
    if(str2.size >= str.size){                                          //比較長度
      str = str2                                                    //置換
    }
    return str                                                     //傳回最長的那個字串
  }
}
