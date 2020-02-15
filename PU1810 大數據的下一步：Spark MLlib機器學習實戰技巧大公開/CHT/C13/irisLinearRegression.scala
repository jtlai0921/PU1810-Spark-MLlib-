import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}


object irisLinearRegression {
 val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("irisLinearRegression ")                            //設定名稱
    val sc = new SparkContext(conf)                                //建立環境變數案例
    val data = sc.textFile("c:/a.txt")								//讀取資料
    val parsedData = data.map { line =>							//處理資料
        val parts = line.split('	')								//按空格分割
        LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).toDouble)) //固定格式
      }.cache()												//載入資料
    val model = LinearRegressionWithSGD.train(parsedData, 10,0.1)	//建立模型
    println("回歸公式為: y = " + model.weights + " * x + " + model.intercept) //列印回歸公式
  }
}
