import org.apache.spark.mllib.regression.IsotonicRegression
import org.apache.spark.{SparkConf, SparkContext}

object IS {
  def main(args: Array[String]) {

val conf = new SparkConf()                                     //建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("IS")                              				//設定名稱
    val sc = new SparkContext(conf)                                 //建立環境變數案例
    val data = MLUtils.loadLibSVMFile(sc, "c://u.txt")				//輸入資料集

    val parsedData = data.map { line =>							//處理資料格式
      val parts = line.split(',').map(_.toDouble)						//切分資料
      (parts(0), parts(1), 1.0)									//分配資料格式
    }

    val model = new IsotonicRegression().setIsotonic(true).run(parsedData)	//建立模型

    model.predictions.foreach(println)							//列印保序回歸模型

    val res = model.predict(5)									//建立預測值
    println(res)												//列印預測結果

  }
}
