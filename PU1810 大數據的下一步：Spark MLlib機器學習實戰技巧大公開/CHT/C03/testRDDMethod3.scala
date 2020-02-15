import org.apache.spark.{SparkContext, SparkConf}

object testRDDMethod3 {
  def main(args: Array[String]) {
val conf = new SparkConf()                                        //建立環境變數
.setMaster("local")                                                //設定本機化處理
.setAppName("testRDDMethod3 ")                                    	   //設定名稱
    val sc = new SparkContext(conf)						       //建立環境變數案例
    val arr = sc.parallelize(Array("abc","b","c","d","e","f"))				   //建立資料集
val result = arr.aggregate("")((value,word) => value + word, _ + _)       //呼叫計算方法	
println(result)						                          //列印結果
  }
}

