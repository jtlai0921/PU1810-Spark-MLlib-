﻿import org.apache.spark.{SparkContext, SparkConf}

object Repartition {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //建立環境變數
.setMaster("local")                                               //設定本機化處理
.setAppName("Repartition ")                                    	  //設定名稱
    val sc = new SparkContext(conf)						       //建立環境變數案例
    val arr = sc.parallelize(Array(1,2,3,4,5,6))						  //建立資料集
arr = arr.repartition(3)                                            //重新分區
println(arr.partitions.length)}                                       //列印分區數         
}
