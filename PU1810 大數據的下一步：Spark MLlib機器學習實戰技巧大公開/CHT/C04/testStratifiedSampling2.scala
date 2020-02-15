object testStratifiedSampling2 {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("testSingleCorrect2 ")                                //設定名稱
    val sc = new SparkContext(conf)                                  //建立環境變數案例
    val data = sc.textFile("c://a.txt")                                   //讀取資料
      .map(row => {                                                //開始處理
      if(row.length == 3)                                            //判斷字元數
        (row,1)                                                    //建立對應map
      else (row,2)                                                  //建立對應map
    })
    val fractions: Map[String, Double] = Map("aa" -> 2)                 //設定抽樣格式
    val approxSample = data.sampleByKey(withReplacement = false, fractions,0) //計算抽樣樣本
    approxSample.foreach(println)                                   //列印結果
  }
}
