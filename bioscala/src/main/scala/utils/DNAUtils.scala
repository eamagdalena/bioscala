package utils

import scala.collection.immutable.Stream.Cons

object DNAUtils {

  type Genome = String

  def dnaToRna(seq: Genome) = {
    seq.replace('T', 'U')
  }

  def reverseComplement(seq: Genome) = {

    seq.map(c => c match {
      case 'A' => 'T'
      case 'T' => 'A'
      case 'G' => 'C'
      case 'C' => 'G'
    }).reverse

  }

  def nextValue(s: String): String = {

    if (s.isEmpty()) s
    else
      s.head match {
        case 'A' => 'T' + s.tail
        case 'T' => 'G' + s.tail
        case 'G' => 'C' + s.tail
        case 'C' => 'A' + nextValue(s.tail)
      }

  }

  def initialValue(n: Int): String = {
    (for (i <- 1 to n) yield 'A').mkString
  }

  def sequenceGenerator(n: Int): Stream[String] = {

    val initial = initialValue(n)

    def sequenceGeneratorRec(s: String): Stream[String] = {

      val next = nextValue(s)

      if (next.equals(initial)) new Cons(s, Stream.Empty)
      else s #:: sequenceGeneratorRec(next)
    }

    sequenceGeneratorRec(initial)

  }

}

object Main extends App {
  Utils.solveSimple("data/chapter1/problem32_2.txt", DNAUtils.reverseComplement)
}