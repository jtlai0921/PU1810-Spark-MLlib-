import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint

object testLabeledPoint {
  def main(args: Array[String]) {
    val vd: Vector =  Vectors.dense(2, 0, 6)                            //建立密集向量
    val pos = LabeledPoint(1, vd)                                     //對密集向量建立標示點
    println(pos.features)                                             //列印標示點內容資料
    println(pos.label)                                                //列印既定標示
val vs: Vector = Vectors.sparse(4, Array(0,1,2,3), Array(9,5,2,7))      //建立稀疏向量
    val neg = LabeledPoint(2, vs)                                    //對密集向量建立標示點
    println(neg.features)                                            //列印標示點內容資料
    println(neg.label)                                               //列印既定標示
  }
}
