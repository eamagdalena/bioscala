package patternmatching
import scala.collection.immutable.HashMap
import utils.Utils

object FrequentWordsWithPositions {

  type Base = Char
  type Genome = List[Char]

  case class State(partialSolutions: List[Genome], results: Map[Genome, List[Int]], depth: Int, currentPosition: Int) {

    def next(c: Base): State = {
      val v = (for (ps <- partialSolutions :+ Nil) yield (c :: ps))

      if (v.head.length == depth)
        new State(v.tail, results + (v.head -> (currentPosition :: (results(v.head)))), depth, currentPosition + 1)
      else
        new State(v, results, depth, currentPosition + 1)
    }
  }

  def solve(genome: String, depth: Int) = {

    val millis = System.currentTimeMillis

    val initialState = State(Nil, new HashMap().withDefaultValue(Nil), depth, 0)

    val finalState = genome
      .toList
      .foldRight(initialState)((base, state) => state.next(base))

    println("Time ellapsed on Frequent Words With Positions : " + (System.currentTimeMillis() - millis))

    finalState.results.toList
  }

}

object FWPMain extends App {
  println(FrequentWordsWithPositions.solve("CGGACTCGACAGATGTGAAGAACGACAATGTGAAGACTCGACACGACAGAGTGAAGAGAAGAGGAAACATTGTAA", 5))
}
