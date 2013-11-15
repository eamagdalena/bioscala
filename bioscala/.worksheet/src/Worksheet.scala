import chapter1._
import congodb._

object Worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(104); 
 
 val v = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14);System.out.println("""v  : List[Int] = """ + $show(v ));$skip(16); 
 
 var suma = 0;System.out.println("""suma  : Int = """ + $show(suma ));$skip(45); 
  for( i <- v)
  	if( i > 5) suma = suma + 1;$skip(13); val res$0 = 
  
  
  suma;System.out.println("""res0: Int = """ + $show(res$0));$skip(49); val res$1 = 
 
 
 //v.filter(_>5).reduce(_+_)
 
 v.count(_>5);System.out.println("""res1: Int = """ + $show(res$1));$skip(21); 
 
 
 
 
 
 val i = 1;System.out.println("""i  : Int = """ + $show(i ));$skip(16); 
 
 val j = i +1;System.out.println("""j  : Int = """ + $show(j ))}
 
 
}
