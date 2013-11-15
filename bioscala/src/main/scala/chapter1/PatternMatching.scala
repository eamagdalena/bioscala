package chapter1

import utils.Utils.solveMultiple

object PatternMatching {

  type Genome = String
  type Pattern = String

  def solve(pattern: Pattern, genome: Genome): String = {

    def solveRec(nextStartIndex: Int, solution: List[String]): List[String] = {

      val next = genome.indexOf(pattern, nextStartIndex)
      if (next == -1) solution
      else solveRec(next + 1, String.valueOf(next) :: solution)

    }

    solveRec(0, Nil).reverse.mkString(" ")
  }

  def solve(params: List[String]): String = solve(params.head, params.tail.head)

  def solve(path: String) {
    solveMultiple(path, solve)
  }

}

object PatternMatchingMain extends App {

  PatternMatching.solve("data/chapter1/dataset_3_5.txt")

}