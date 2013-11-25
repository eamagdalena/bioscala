package chapter2

import utils.PeptidUtils._
import utils.Utils._
import utils.DNAUtils._

object PeptideEncoding {

  def miniStream(dna: String): Stream[String] = if (dna.isEmpty()) Stream.Empty else dna.take(3) #:: miniStream(dna.drop(3))

  def matches(stream: Stream[String], peptide: String): Boolean = {

    if (peptide.isEmpty()) true
    else if (stream.isEmpty) false
    else if (stream.head.size < 3) false
    else if (peptide.head == codonTableChar(stream.head)) matches(stream.tail, peptide.tail)
    else false
  }

  def matches(miniDna: String, peptide: String): Boolean = {
    matches(miniStream(dnaToRna(miniDna)), peptide) || matches(miniStream(dnaToRna(reverseComplement(miniDna))), peptide)
  }

  /* Give sequences of pepSize*3  starting at each single character */
  def dnaStream(dna: String, pepSize: Int): Stream[String] = if (dna.isEmpty()) Stream.Empty else dna.take(3 * pepSize) #:: dnaStream(dna.tail, pepSize)

  def solveFile(v: List[String]) = solve(v.head, v.tail.head)

  def solve(dna: String, peptide: String) = {

    def solveRec(stream: Stream[String], res: List[String]): List[String] = {

      if (stream.isEmpty)
        res
      else if (matches(stream.head, peptide))
        solveRec(stream.tail, stream.head.mkString("") :: res)
      else
        solveRec(stream.tail, res)
    }

    solveRec(dnaStream(dna, peptide.size), Nil)

  }

}

object PEMain extends App {

  //println(PeptideEncoding.solve("ATGGCCATGGCCCCCAGAACTGAGATCAATAGTACCCGTATTAACGGGTGA", "MA"))

  solveMultiplePretty("data/chapter2/dataset_18_6.txt", PeptideEncoding.solveFile)

}
