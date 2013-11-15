package chapter1

import utils.Utils
import patternmatching.FrequentWordsWithPositions

object FindingClumps {

  type Genome = String

  def findAppereancesOnClump(positions: List[Int], L: Int, k: Int): Int = {

    val Lmk = L - k

    def findRec(positions: List[Int], max: Int): Int = {

      if (positions.isEmpty) max
      else {
        val count = 1 + positions.tail.count(x => positions.head - x <= Lmk)
        findRec(positions.tail, if (count > max) count else max)
      }
    }

    findRec(positions, 0)
  }

  // k: subgenome size, L clump size, t, minimun number of appereances
  def solve(genome: Genome, k: Int, L: Int, t: Int) = {

    val fwp = FrequentWordsWithPositions.solve(genome, k).filter(_._2.size > 1)

    (for {
      fp <- fwp
      if (fp._2.length >= t)
      val apps = findAppereancesOnClump(fp._2, L, k)
      if (apps >= t)
    } yield fp).map(x => new String(x._1.toArray))

  }

  def pretty(sol: List[String]) = sol.mkString(" ")

  def solveFile(path: String) = {

    val fileContents = Utils.fromFile(path)
    val numbers = fileContents.tail.head.split(" ")

    solve(fileContents.head, Integer.parseInt(numbers(0)), Integer.parseInt(numbers(1)), Integer.parseInt(numbers(2)))
  }

}

object FCMain extends App {
  val millis = System.currentTimeMillis()

  val sol = FindingClumps.solve(Utils.fromFile("data/genomes/E-coli.txt").head, 9, 500, 3)

  println(sol.length)

  println(sol.distinct.length)

  println(FindingClumps.pretty(sol))

  println("Time ellapsed " + (System.currentTimeMillis() - millis))

  Utils.toFile(FindingClumps.pretty(sol), "data/chapter1/coli_sol.txt")

}