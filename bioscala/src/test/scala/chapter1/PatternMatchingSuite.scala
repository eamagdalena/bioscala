package chapter1

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import chapter1.PatternMatching._
import utils.DNAUtils
import utils.Utils

@RunWith(classOf[JUnitRunner])
class PatternMatchingSuite extends FunSuite {

  test("Basic Pattern Matching") {
    assert(solve("ATAT", "GATATATGCATATACTT") === "1 3 9")
  }

  test("Basic Pattern Matching By File") {

    solve("data/chapter1/test/simplePatternMatching.txt")

    assert(Utils.fromFile("data/chapter1/test/simplePatternMatching.txt.solved.txt").head === "1 3 9")
  }

  test("Vibrio_cholerae.txt") {

    println(solve("CTTGATCAT", Utils.fromFile("data/genomes/Vibrio_cholerae.txt").head))

  }

}