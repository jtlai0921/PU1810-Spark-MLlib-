import org.apache.spark.mllib.fpm.FPGrowth
import org.apache.spark.{SparkConf, SparkContext}
object FPTree {

  def main(args: Array[String]) {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("FPTree ")                              		//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = sc.textFile("c://fp.txt")								//讀取資料
    val fpg = new FPGrowth().setMinSupport(0.3)			//建立FP數案例並設定最小支援度
    val model = fpg.run(data)									//建立模型

  }
}
