package chapter2

import utils.PeptidUtils._
import utils.Utils._
import utils.DNAUtils._
import chapter2.Subpeptides._

class LeaderboardCyclopeptideSequencing(N: Int, spectrum: List[Int]) {

  lazy val INITIAL = (List[Int](), 0)

  type Spectrum = List[Int]
  type Masses = List[Int]
  type Solution = (Spectrum, Int)

  val targetMass = spectrum.last

  private def score(s: Masses): Int = {

    val initial = (spectrum, 0)

    computeTheoricalSpectrum(s)
      .foldLeft(initial)(
        (v, mass) => {

          if (v._1.isEmpty) v
          else {

            val l = v._1.dropWhile(_ < mass)

            if (l.isEmpty) (l, -1)
            else if (l.head == mass) (l.tail, v._2 + 1)
            else (l, v._2)

          }

        })
      ._2

    //.count(spectrum.contains(_))

  }

  def expand(l: List[Solution]): List[Solution] = {

    for {
      i <- l
      j <- massOnlyList
      sol = j :: i._1
      solScore = score(sol)
      if (solScore > i._2) //  && sol.sum <= targetMass
    } yield (sol, solScore)

  }

  private def cutAndSort(leaderboard: List[Solution]): List[Solution] = {
    val sorted = leaderboard.sortBy(-_._2)

    val top = sorted.take(N)

    lazy val lastScore = top.last._2

    top ++ top.drop(N).takeWhile(_._2 == lastScore)

  }

  private def solveRec(leaderboard: List[Solution], leader: Solution): Solution = {

    val expanded = expand(leaderboard)

    if (expanded.isEmpty) leader
    else {
      val cutted = cutAndSort(expanded)
      solveRec(cutted, if (leader._2 < cutted.head._2) cutted.head else leader)
    }
  }

  def solveMe: Spectrum = solveRec(List(INITIAL), INITIAL)._1

}

object LeaderboardCyclopeptideSequencing {

  def solve(N: Int, spectrum: List[Int]) = {
    new LeaderboardCyclopeptideSequencing(N, spectrum).solveMe
  }

  def solvePretty(v: List[String]) = solve(v.head.toInt, v(1).split(" ").toList.map(_.toInt)).mkString("-")

}

object LCSMain extends App {

  //solveMultiple("data/chapter2/dataset_24_4.txt", LeaderboardCyclopeptideSequencing.solvePretty)

  println(LeaderboardCyclopeptideSequencing.solve(10, List(0, 71, 113, 129, 147, 200, 218, 260, 313, 331, 347, 389, 460)))

}