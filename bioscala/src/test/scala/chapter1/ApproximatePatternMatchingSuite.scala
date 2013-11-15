package chapter1

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import chapter1.ApproximatePatternMatching._
import utils.DNAUtils
import utils.Utils._

@RunWith(classOf[JUnitRunner])
class ApproximatePatternMatchingSuite extends FunSuite {

  test("Basic Pattern Matching") {
    assert(pretty(solve("ATTCTGGA", "CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAAT", 3)) === "6 7 26 27")
  }

  test("Extra Data Set") {

    val l = fromFile("data/chapter1/approximate_match_data.txt")

    assert(pretty(solve(l.tail.head, l.tail.tail.head, l.tail.tail.tail.head.toInt)) === l.tail.tail.tail.tail.tail.head)

  }

}