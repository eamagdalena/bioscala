package chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import chapter2.PeptideEncoding._
import utils.Utils._

@RunWith(classOf[JUnitRunner])
class PeptideEncodingSuite extends FunSuite {

  test("test 1") {

    val v = fromFile("data/chapter2/peptide_encoding_data.txt")

    assert(solve(v(1), v(2)).length === v.drop(4).length)
    assert(solve(v(1), v(2)).sorted === v.drop(4).sorted)

  }

}