import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}


object irisLogicRegression{
val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("irisLogicRegression ")                            //設定名稱
    val sc = new SparkContext(conf)                                //建立環境變數案例
    val data = sc.textFile("c:/a.txt")								//讀取資料
    val parsedData = data.map { line =>							//處理資料
        val parts = line.split('	')								//按空格分割
        LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).toDouble)) //固定格式
      }.cache()												//載入資料
    val model = irisLogicRegression.train(parsedData, 20)	         //建立模型
val valuesAndPreds = parsedData.map { point => {				//建立均方誤差訓練資料
    val prediction = model.predict(point.features)					//建立資料
      (point.label, prediction)									//建立預測資料
}
    val MSE = valuesAndPreds.map{ case(v, p) => math.pow((v - p), 2)}.mean() //計算均方誤差
println(“均方誤差結果為:” + MSE)  							//列印結果
}
}

