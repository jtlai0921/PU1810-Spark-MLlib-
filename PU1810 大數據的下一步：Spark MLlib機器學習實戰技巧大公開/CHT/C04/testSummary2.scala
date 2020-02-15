object testSummary{
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testSummary2")                                    //設定名稱
    val sc = new SparkContext(conf)                                   //建立環境變數案例
    val rdd = sc.textFile("c://a.txt")                                     //建立RDD檔案路徑
      .map(_.split(' ')                                                //按“ ”分割
      .map(_.toDouble))                                             //轉成Double型態
      .map(line => Vectors.dense(line))                                //轉成Vector格式
    val summary = Statistics.colStats(rdd)						  //取得Statistics案例
    println(summary.normL1)                                         //計算曼哈段距離
    println(summary.normL2)                                        //計算歐幾裡得距離
  }
}

