import scala.collection.mutable.HashMap

object SGD {
  val data = HashMap[Int,Int]()									//建立資料集
  def getData():HashMap[Int,Int] = {								//產生資料集內容
    for(i <- 1 to 50){											//建立50個資料
      data += (i -> (12*i))										//寫入公式y=2x
    }
    data													//傳回資料集
  }

  var θ:Double = 0											//第一步假設θ為0
  var α:Double = 0.1 										//設定步進系數	

  def sgd(x:Double,y:Double) = {								//設定迭代公式
    θ = θ - α * ( (θ*x) - y)										//迭代公式
  }
  def main(args: Array[String]) {
    val dataSource = getData()									//取得資料集
    dataSource.foreach(myMap =>{								//開始迭代
      sgd(myMap._1,myMap._2)								//輸入資料
    })
    println(“最終結果θ值為 ” + θ)								//顯示結果
  }
}
