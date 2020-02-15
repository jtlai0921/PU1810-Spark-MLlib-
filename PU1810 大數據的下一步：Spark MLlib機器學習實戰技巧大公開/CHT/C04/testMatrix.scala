import org.apache.spark.mllib.linalg.{Matrix, Matrices}

object testMatrix {
  def main(args: Array[String]) {                                      
    val mx = Matrices.dense(2, 3, Array(1,2,3,4,5,6))                    //建立一個分散式矩陣
    println(mx)                                                     //列印結果
  }
}
