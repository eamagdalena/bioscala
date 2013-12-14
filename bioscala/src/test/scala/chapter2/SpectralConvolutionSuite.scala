package chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import utils.Utils._
import SpectralConvolution._

@RunWith(classOf[JUnitRunner])
class SpectralConvolutionSuite extends FunSuite {

//  test("extra data set") {
//
//    val v = fromFile("data/chapter2/spectral_convolution_data.txt")
//
//    val result = solve(v(1).split(" ").toList.map(_.toInt)).sorted
//
//    val expectedResult = v(3).split(" ").toList.map(_.toInt).sorted
//
//    println(result)
//    println(expectedResult)
//
//    assert(result === expectedResult)
//
//  }

  test("leader board") {
    
    val v = fromFile("data/chapter2/convolutional_seq_data.txt")
    
    val M = v(1).toInt
    val N = v(2).toInt
    val spectrum = v(3).split(" ").map(_.toInt).toList
    
    
    println(ConvolutionCyclopeptideSequencing.solve(M, N, spectrum))
   
    // 147-99-114-57-129-87-71-137-87-101-129-147-57
    
  }
  
  
}