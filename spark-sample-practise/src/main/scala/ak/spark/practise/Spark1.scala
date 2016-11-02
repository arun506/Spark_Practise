package ak.spark.practise
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
/**
 * @author pju7771
 */
object Spark1 {
  def main(args : Array[String]):Unit = {
    val conf = new SparkConf().setMaster("local[4]").setAppName("sample")
    val sc = new SparkContext(conf)
    val txt = sc.textFile(args(0))
    val splt = txt.flatMap(x => x.split(" "))
    val resplt = splt.map(y => (y,1) ).reduceByKey(_+_)
    val lstArr = resplt.toArray()
    val lst = lstArr.toList
    println("wordCnt " + lst)
   
  }
}