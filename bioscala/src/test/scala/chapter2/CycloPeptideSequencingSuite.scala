package chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import CyclopeptideSequencing._
import utils.Utils._

@RunWith(classOf[JUnitRunner])
class CycloPeptideSequencingSuite extends FunSuite {

  test("test extra data set") {

    val v = fromFile("data/chapter2/cycloseq_data.txt")

    assert(solvePretty(v(1)) === v(3))

  }

}