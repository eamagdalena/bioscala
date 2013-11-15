package chapter1

import scala.io.Source
import scala.collection.immutable.HashMap
import utils.Utils._
import utils.DNAUtils._

object FrequentWordsWithMissmatches {

  def solve(text: String, k: Int, d: Int) = {

    val stream = sequenceGenerator(k)
      .map(x => (x, ApproximatePatternMatching.solveCount(x, text, d)))

    val list = stream.toList

    mostFrequent(list.filter(_._2 > 1))

  }

  def solveWithReverseCompliment(text: String, k: Int, d: Int) = {

    val stream = sequenceGenerator(k)
      .map(x => (x, ApproximatePatternMatching.solveCount(x, text, d) + ApproximatePatternMatching.solveCount(reverseComplement(x), text, d)))

    val list = stream.toList

    mostFrequent(list.filter(_._2 > 1)).reverse

  }

  def mostFrequent(results: List[(String, Int)]): List[String] = {
    val max = results.foldLeft(0)((max, elem) => if (max >= elem._2) max else elem._2)
    results.filter(_._2 == max).toList.map(_._1)
  }

  def solveFile(s: String) = {

    val ss = s.split(" ")

    solve(ss.head, ss(1).toInt, ss(2).toInt)

  }

  def solveFileWithReverse(s: String) = {

    val ss = s.split(" ")

    solveWithReverseCompliment(ss.head, ss(1).toInt, ss(2).toInt)

  }

}

object FWWMMain extends App {

  println(FrequentWordsWithMissmatches.solveWithReverseCompliment("CGCGGCGCCGCTGTCGCGATTCGCGCGCGTCGCGGTCGCCGCCGCCGCGTATTATTTTGTCGCATGCGCCGCGTCGCCGCTGTTTTATGCGCATTCGCATCGCATTTATGGTCGCGTCGCATTCGCTGTTATATTGGTATGATCGCGGTGTGATATGGCGCCGCGTGGTCGCATTATGTCGCATATGGTATCGCCGCCGCGTATGTT", 9, 2))

  //solveSimplePretty("data/chapter1/dataset_8_5.txt", FrequentWordsWithMissmatches.solveFileWithReverse)

}

//
//  def computeList(text: String, k: Int): Set[String] = {
//
//    def computeRec(textR: String, res: Set[String]): Set[String] = {
//
//      val v = textR.take(k)
//
//      if (v.length == k) computeRec(textR.tail, res + v)
//      else res
//
//    }
//
//    computeRec(text, Set())
//
//  }