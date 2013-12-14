package utils

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import utils.Streams._

@RunWith(classOf[JUnitRunner])
class StreamsSuite extends FunSuite {

  test("Basic DNA Stream") {
    assert(dnaStream("ABC", 2).toList === List("AB","BC"))
  }

}