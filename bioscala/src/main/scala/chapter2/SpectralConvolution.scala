package chapter2

import utils.PeptidUtils._
import utils.Utils._

object SpectralConvolution {

  type Spectrum = List[Int]

  private def convolutionStream(spectrum: Spectrum): Stream[Spectrum] = {
    if (spectrum.isEmpty) Stream.Empty
    else spectrum.tail.map(spectrum.head - _) #:: convolutionStream(spectrum.tail)
  }

  def solve(spectrum: Spectrum) = {
    val res = convolutionStream(spectrum.sortBy(-_)).toList

    res.flatten.filter(_ != 0) //.filter(massOnlyList.contains(_))
  }

  def prettySolve(s: String): String = solve(s.split(" ").toList.map(_.toInt)).mkString(" ")

}

object SCMain extends App {

  solveSimple("data/chapter2/dataset_26_4.txt", SpectralConvolution.prettySolve)

}