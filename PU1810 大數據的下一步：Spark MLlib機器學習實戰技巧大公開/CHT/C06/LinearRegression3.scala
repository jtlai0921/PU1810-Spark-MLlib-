import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}

object LinearRegression {
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                              //設定本機化處理
.setAppName("LinearRegression3 ")                               //設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例

  def main(args: Array[String]) {
    val data = sc.textFile("c:/lr.txt")							  	 //取得資料集路徑
    val parsedData = data.map { line =>							 //開始對資料集處理
      val parts = line.split('|')									 //根據逗點進行分區
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(',').map(_.toDouble)))
    }.cache()                                                      //轉化資料格式
    val model = LinearRegressionWithSGD.train(parsedData, 2,0.1)	  	//建立模型
val valuesAndPreds = parsedData.map { point => {				//取得真實值與預測值
      val prediction = model.predict(point.features)					//對系數進行預測
      (point.label, prediction)									//按格式儲存
      }
    }

val MSE = valuesAndPreds.map{ case(v, p) => math.pow((v - p), 2)}.mean() //計算MSE
println(MSE)
  }

}
