import org.apache.spark._
import org.apache.spark.mllib.recommendation.{ALS, Rating}

object CollaborativeFilter {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("CollaborativeFilter ")	//設定環境變數
val sc = new SparkContext(conf)                                 //案例化環境
    val data = sc.textFile("c://u1.txt")								//設定資料集
val ratings = data.map(_.split(' ') match {						//處理資料
 case Array(user, item, rate) => 							//將資料集轉化
      Rating(user.toInt, item.toInt, rate.toDouble)				//將資料集轉化為私人Rating
    })
    val rank = 2											//設定隱藏因子
    val numIterations = 2										//設定迭代次數
    val model = ALS.train(ratings, rank, numIterations, 0.01)			//進行模型訓練
    var rs = model.recommendProducts(2,1)						//為使用者2推薦一個商品
    rs.foreach(println)										//列印結果
  }
}
