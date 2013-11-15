package chapter1

import utils.Utils._

object ApproximatePatternMatching {

  def computeList(text: String, pattern: String): List[List[Int]] = {
    (for {
      i <- Range(0, pattern.length)
      c = pattern(i)
    } yield text.drop(i).map(x => if (x == c) 1 else 0).toList).toList
  }

  def sum(res: List[Int], e: List[Int]): List[Int] = if (res.isEmpty) e else (res, e).zipped.map(_ + _)

  def solutions(res: List[Int], min: Int): List[Int] = {

    def solutionsRec(input: List[Int], output: List[Int]): List[Int] = {

      val v = input.indexWhere(_ >= min)

      if (v == -1) output else solutionsRec(input.updated(v, 0), v :: output)

    }

    solutionsRec(res, Nil).reverse

  }

  def solveCount(pattern: String, text: String, d: Int): Int = {
    computeList(text, pattern).foldLeft(List[Int]())(sum).count(_ >= pattern.size - d)
  }

  def solve(pattern: String, text: String, d: Int): List[Int] = {
    solutions(computeList(text, pattern).foldLeft(List[Int]())(sum), pattern.size - d)
  }

  def solveListParams(l: List[String]): List[Int] = {
    solve(l.head, l.tail.head, Integer.parseInt(l.tail.tail.head))
  }

}

object APMMAin extends App {

  solveMultiple("data/chapter1/dataset_8_3.txt", ApproximatePatternMatching.solveListParams _ andThen pretty _)

}