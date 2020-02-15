import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{SparkConf, SparkContext}

object SVD {
  def main(args: Array[String]) {				
val conf = new SparkConf()                                   	//建立環境變數
.setMaster("local")                                             //設定本機化處理
.setAppName("SVD ")                                    		//設定名稱
val sc = new SparkContext(conf)                                 //建立環境變數案例

    val data = sc.textFile("c://a.txt")                                   //建立RDD檔案路徑
      .map(_.split(' ')                                               //按“ ”分割
      .map(_.toDouble))                                            //轉成Double型態
      .map(line => Vectors.dense(line))                               //轉成Vector格式

    val rm = new RowMatrix(data)                                    //讀入行矩陣
    val SVD = rm.computeSVD(2, computeU = true)					 //進行SVD計算
println(SVD)											 //列印SVD結果矩陣
  }
}

