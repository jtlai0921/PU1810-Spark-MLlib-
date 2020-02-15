import scala.collection.mutable
import scala.io.Source

object Apriori{

  def main(args: Array[String]) {

    val minSup = 2											//設定最小支援度
    val list = new mutable.LinkedHashSet[String]()					//設定可變清單
Source.fromFile("c://apriori.txt").getLines()						//讀取資料集並儲存
.foreach(str => list.add(str))								//將資料儲存
    var map = mutable.Map[String,Int]()							//設定map進行計數
    list.foreach(strss => {										//計算開始
      val strs = strss.split("、")									//分割資料
      strs.foreach(str => {									//開始計算程式
        if(map.contains(str)){									//判斷是否存在
          map.update(str,map(str) + 1)							//對已有資料+1
        } else map += (str -> 1)								//將未儲存的資料加入
      })
    })

    val tmpMap = map.filter(_._2 > minSup)						//判斷最小支援度

    val mapKeys = tmpMap.keySet								//分析清單內容
    val tempList = new mutable.LinkedHashSet[String]()				//創先輔助List
    val conList = new mutable.LinkedHashSet[String]()				//建立連線List
    mapKeys.foreach(str => tempList.add(str))						//進行連線準備
    tempList.foreach(str => {									//開始連線
      tempList.foreach(str2 =>{								//讀取輔助List
        if(str != str2){										//判斷
          val result = str + "、" + str2							//建立連線字元
          conList.add(result)									//加入
        }
      })
    })

    conList.foreach(strss => {								  //開始對原始清單進行比對
      val strs = strss.split("、")									//切分資料
      strs.foreach(str => {									//開始計數
        if(map.contains(str)){									//判斷是否包括
          map.update(str,map(str) + 1)							//對已有資料+1
        } else map += (str -> 1)								//將未儲存的資料加入
      })
    })
  }
}
