import org.apache.spark.{SparkContext, SparkConf}
object wordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("wordCount")	//建立環境變數
    val sc = new SparkContext(conf)								//建立環境變數案例
    val data = sc.textFile("c://wc.txt")								//讀取檔案
    data.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)	//word計數
  }
}
