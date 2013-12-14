package utils

object DNAComparisonUtils {

  def equivalent(dna1: String, dna2: String, d: Int): Boolean = {
    dna1.length() - (dna1, dna2).zipped.foldLeft(0)(
      (suma, c) => if (c._1 == c._2) suma + 1 else suma) <= d
  }

}