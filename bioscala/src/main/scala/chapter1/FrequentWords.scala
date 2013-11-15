package chapter1

import scala.io.Source
import scala.collection.immutable.HashMap
import utils.Utils

object FrequentWords {

  type Base = Char
  type Genome = List[Char]

  case class State(partialSolutions: List[Genome], results: Map[Genome, Int], depth: Int) {

    def next(c: Base): State = {

      val v = (for (ps <- partialSolutions :+ Nil) yield (c :: ps))

      if (v.head.length == depth)
        new State(v.tail, results + (v.head -> (results(v.head) + 1)), depth)
      else
        new State(v, results, depth)
    }

    def mostFrequent = {
      val pl = results.toList.sortBy(-_._2)
      val max = pl.head._2
      println(max)
      pl.filter(_._2 == max).map(x => String.valueOf(x._1.toArray)).mkString(" ")
    }

  }

  def solve(genome: String, depth: Int) = {
    genome
      .toList
      .foldRight(State(Nil, new HashMap().withDefaultValue(0), depth))((base, state) => state.next(base))
      .mostFrequent
  }

  def solveFile(path: String) = {
    val v = Utils.fromFile(path)
    solve(v.head, Integer.parseInt(v.tail.head))
  }

}

object Main extends App {

  //println(FrequentWords.solveFile("data/chapter1/quiz1.txt"))
  //println(FrequentWords.solve("data/chapter1/simple.txt"))

}