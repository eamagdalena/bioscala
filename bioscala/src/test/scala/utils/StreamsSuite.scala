package utils

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import utils.Streams._

@RunWith(classOf[JUnitRunner])
class StreamsSuite extends FunSuite {

  test("Basic DNA Stream") {
    assert(dnaStream("ABC", 2).toList === List("AB", "BC"))
  }

  test("Basic Mutations") {
    assert(mutations("A") === Set("C", "G", "T"))
  }

  test("Basic Mutations 2") {
    assert(mutations("AA") === Set("CA", "GA", "TA", "AC", "AT", "AG"))
  }

  test("Complex Mutation 1") {

    println(mutations(Set("AAA", "GGG"), 2))

  }

}