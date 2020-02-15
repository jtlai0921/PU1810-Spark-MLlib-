import org.apache.spark.{SparkConf, SparkContext}
import scala.collection.mutable.Map


object CollaborativeFilteringSpark {
val conf = new SparkConf().setMaster("local").setAppName("CollaborativeFilteringSpark ")	//設定環境變數
val sc = new SparkContext(conf)                                 //案例化環境
val users = sc.parallelize(Array("aaa","bbb","ccc","ddd","eee"))       //設定使用者
val films = sc.parallelize(Array("smzdm","ylxb","znh","nhsc","fcwr"))	//設定電影名
   
val source = Map[String,Map[String,Int]]()				//使用一個source嵌套map作為姓名電影名和分值的儲存
   val filmSource = Map[String,Int]() 					//設定一個用以存放電影分的map
   def getSource(): Map[String,Map[String,Int]] = {			//設定電影評分
     val user1FilmSource = Map("smzdm" -> 2,"ylxb" -> 3,"znh" -> 1,"nhsc" -> 0,"fcwr" -> 1)
     val user2FilmSource = Map("smzdm" -> 1,"ylxb" -> 2,"znh" -> 2,"nhsc" -> 1,"fcwr" -> 4)
     val user3FilmSource = Map("smzdm" -> 2,"ylxb" -> 1,"znh" -> 0,"nhsc" -> 1,"fcwr" -> 4)
     val user4FilmSource = Map("smzdm" -> 3,"ylxb" -> 2,"znh" -> 0,"nhsc" -> 5,"fcwr" -> 3)
     val user5FilmSource = Map("smzdm" -> 5,"ylxb" -> 3,"znh" -> 1,"nhsc" -> 1,"fcwr" -> 2)
     source += ("aaa" -> user1FilmSource)				//對人名進行儲存
     source += ("bbb" -> user2FilmSource) 				//對人名進行儲存
     source += ("ccc" -> user3FilmSource) 				//對人名進行儲存
     source += ("ddd" -> user4FilmSource) 				//對人名進行儲存
     source += ("eee" -> user5FilmSource) 				//對人名進行儲存
     source										//傳回嵌套map
   }

   //兩兩計算分值,采用余弦相似性
   def getCollaborateSource(user1:String,user2:String):Double = {
     val user1FilmSource = source.get(user1).get.values.toVector		//獲得第1個使用者的評分
     val user2FilmSource = source.get(user2).get.values.toVector		//獲得第2個使用者的評分
val member = user1FilmSource.zip(user2FilmSource).map(d => d._1 * d._2).reduce(_ + _   _).toDouble												//對公式分子部分進行計算
     val temp1  = math.sqrt(user1FilmSource.map(num => {			//求出分母第1個變數值
       math.pow(num,2)										//數學計算
     }).reduce(_ + _))										//進行疊加
     val temp2  = math.sqrt(user2FilmSource.map(num => {			////求出分母第2個變數值
       math.pow(num,2) 									//數學計算
     }).reduce(_ + _))										//進行疊加
     val denominator = temp1 * temp2							//求出分母
     member / denominator									//進行計算
}

   def main(args: Array[String]) {
     getSource()											//起始化分數
     val name = "bbb"										//設定目的物件
    users.foreach(user =>{									//迭代進行計算
      println(name + " 相對於 " + user +"的相似性分數是："+ getCollaborateSource(name,user))
    })
   }
 }
