package chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import utils.Utils._
import SpectralConvolution._

@RunWith(classOf[JUnitRunner])
class SpectralConvolutionSuite extends FunSuite {

  test("extra data set") {

    val v = fromFile("data/chapter2/spectral_convolution_data.txt")

    val result = solve(v(1).split(" ").toList.map(_.toInt)).sorted

    val expectedResult = v(3).split(" ").toList.map(_.toInt).sorted

    println(result)
    println(expectedResult)

    assert(result === expectedResult)

  }

}