import chapter1._
import congodb._

object Worksheet {
 
 val v = List(1,2,3,4,5,6,7,8,9,10,11,12,13,14)   //> v  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
 
 var suma = 0                                     //> suma  : Int = 0
  for( i <- v)
  	if( i > 5) suma = suma + 1
  
  
  suma                                            //> res0: Int = 9
 
 
 //v.filter(_>5).reduce(_+_)
 
 v.count(_>5)                                     //> res1: Int = 9
 
 
 
 
 
 val i = 1                                        //> i  : Int = 1
 
 val j = i +1                                     //> j  : Int = 2
 
 
}