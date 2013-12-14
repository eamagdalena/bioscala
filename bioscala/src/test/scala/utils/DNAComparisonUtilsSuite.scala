package utils

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import utils.DNAComparisonUtils._

@RunWith(classOf[JUnitRunner])
class DNAComparisonUtilsSuite extends FunSuite {

  test("Basic Comparison") {

    assert(equivalent("AAA", "AAC", 1))

    assert(equivalent("AAA", "AAC", 2))

    assert(equivalent("AAAAA", "AACAA", 2))

    assert(equivalent("AAAAA", "AACAC", 2))

    assert(!equivalent("AAAAA", "CACAC", 2))

  }

}