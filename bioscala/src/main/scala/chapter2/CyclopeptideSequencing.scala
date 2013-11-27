package chapter2

import utils.PeptidUtils._
import utils.Utils._
import utils.DNAUtils._
import chapter2.Subpeptides._

object CyclopeptideSequencing {

  type RES = Int

  val MATCH = 1
  val PARTIAL = 0
  val MISSMATCH = -1

  def compare(masses: List[Int], spectrum: List[Int]): RES = {

    val finalSpectrum = computeTheoricalSpectrum(masses) 

    if (finalSpectrum == spectrum) {
      //println("MATCH " + masses + " => " + finalSpectrum)
      MATCH
    } else {
      val linearSpectrum = computeTheoricalLinearSpectrum(masses)

      if (linearSpectrum.exists(!spectrum.contains(_))) {
        //println("MISS " + masses + " => " + linearSpectrum)
        MISSMATCH
      } else {
        //println("PARTIAL " + masses + " => " + linearSpectrum)
        PARTIAL
      }
    }
  }

  def solveRec(partial: List[Int], spectrum: List[Int], solutions: List[List[Int]]): List[List[Int]] = {

    compare(partial, spectrum) match {

      case MATCH => partial :: solutions
      case MISSMATCH => {
        solutions
      }
      case PARTIAL => {
        massOnlyList.foldLeft(solutions)((s, mass) => solveRec(partial :+ mass, spectrum, s))
      }

    }
  }

  def solve(spectrum: List[Int]): List[List[Int]] = {
    massOnlyList.foldLeft(List[List[Int]]())((s, mass) => solveRec(List(mass), spectrum, s))
  }

  def solve(s: String): List[List[Int]] = {
    solve(s.split(" ").map(_.toInt).toList)
  }

  def solvePretty(s: String) = {
    pretty(solve(s))
  }

  def pretty(l: List[List[Int]]): String = l.map(_ mkString "-").sorted.reverse.mkString(" ")

}

object CSMain extends App {

  solveSimple("data/chapter2/dataset_22_4.txt", CyclopeptideSequencing.solvePretty)

  //println(CyclopeptideSequencing.solvePretty("0 113 128 186 241 299 314 427"))

  //println(computeTheoricalSpectrum(List(103, 137, 71, 131, 114, 113, 113, 115, 99, 97)))

  //println(CyclopeptideSequencing.pretty(CyclopeptideSequencing.solve(List(0, 113, 128, 186, 241, 299, 314, 427))))

}