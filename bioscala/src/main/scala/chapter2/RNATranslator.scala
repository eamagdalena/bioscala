package chapter2

import utils.PeptidUtils._
import utils.Utils._
object RNATranslator {

  def rna3Stream(rna: String): Stream[String] = if (rna.isEmpty()) Stream.Empty else rna.take(3) #:: rna3Stream(rna.drop(3))

  def toProtein(rna: String) = rna3Stream(rna).map(codonTable(_)).toList.mkString("")

}

object RNATMain extends App {

  solveSimple("data/chapter2/dataset_18_3.txt", RNATranslator.toProtein)
}
