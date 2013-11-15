package chapter1

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import chapter1.FindingClumps._

@RunWith(classOf[JUnitRunner])
class FindingClumpsSuite extends FunSuite {

  test("super simple") {
    assert(pretty(solve("CGGACTCGACAGATGTGAAGAACGACAATGTGAAGACTCGACACGACAGAGTGAAGAGAAGAGGAAACATTGTAA", 5, 50, 4)) === "CGACA GAAGA")
  }

  test("simple") {
    assert(pretty(solveFile("data/chapter1/test/simpleFindingClumps.txt")) === "AAACCAGGTGG")
  }

}