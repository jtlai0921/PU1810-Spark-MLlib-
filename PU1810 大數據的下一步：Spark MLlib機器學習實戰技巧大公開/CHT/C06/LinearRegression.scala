import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}

object LinearRegression {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                              //設定本機化處理
.setAppName("LinearRegression ")                               //設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例

  def main(args: Array[String]) {
    val data = sc.textFile("c:/lpsa2.data")							//取得資料集路徑
    val parsedData = data.map { line =>							//開始對資料集處理
      val parts = line.split(',')									//根據逗點進行分區
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }.cache()                                                     //轉化資料格式
    val model = LinearRegressionWithSGD.train(parsedData, 100,0.1)	//建立模型
    val result = model.predict(Vectors.dense(2))					//透過模型預測模型
    println(result)											//列印預測結果
  }

}
