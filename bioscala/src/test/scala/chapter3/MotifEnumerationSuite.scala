package chapter3

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import chapter3.MotifEnumeration._
import utils.Utils._

@RunWith(classOf[JUnitRunner])
class MotifEnumerationSuite extends FunSuite {

  test("test provided example") {

    val l = List("ATTTGGC", "TGCCTTA", "CGGTATC", "GAAAATT")

    assert(solve(l, 3, 1) === List("ATA", "ATT", "GTT", "TTT"))
  }

  test("test provided example 2") {

    val v = fromFile("data/chapter3/motif_enumeration_data.txt")

    val k = v(1).charAt(0).toInt - 48
    val d = v(1).charAt(2).toInt - 48

    val l = v.drop(2).take(6)

    val res = v.drop(9).head.split(" ").toList.sorted

    val myRes = solve(l, k, d)

    println(l)
    println(k)
    println(d)

    println(res.length)
    println(myRes.length)

    (res, myRes).zipped.foreach((S1, S2) => if (!S1.equals(S2)) println(S1 + " NOT IS " + S2))

    assert(myRes === res)
  }

}