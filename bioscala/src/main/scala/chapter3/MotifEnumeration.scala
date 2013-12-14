package chapter3

import utils.Streams._
import utils.DNAComparisonUtils._
import utils.Utils._

object MotifEnumeration {

  def solve(dnaList: List[String], k: Int, d: Int) = {

    val dnaStreamSet = (for (dna <- dnaList) yield dnaStream(dna, k).toSet).toSet
    val apSet = mutations(dnaStreamSet.flatten, d)

    apSet.filter {

      s => dnaStreamSet.forall(dnaSet => dnaSet.exists(dna => equivalent(dna, s, d)))

    }.toList.sorted

  }

  def solveFromFile(v: List[String]) = {
    val k = v(0).charAt(0).toInt - 48

    val d = v(0).charAt(2).toInt - 48

    solve(v.tail, k, d)

  }

}

object MEMain extends App {
  solveMultiplePretty("data/chapter3/dataset_36_7.txt", MotifEnumeration.solveFromFile)
}