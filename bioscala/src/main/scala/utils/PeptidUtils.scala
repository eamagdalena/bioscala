package utils

import Utils._

object PeptidUtils {

  lazy val massList = massTable.toList

  lazy val massTable = {

    val v = fromFile("data/chapter2/tables/integer_mass_table_bis.txt")

    v.map(s => {
      val ss = s.split(' ')
      (ss(0).charAt(0), ss(1).toInt)
    }).toMap

  }

  lazy val codonTable = {

    val v = fromFile("data/chapter2/tables/RNA_codon_table_1.txt")

    v.map(s => {
      val ss = s.split(' ')

      if (ss.length == 2) (ss(0), ss(1))
      else (ss(0), "")
    }).toMap

  }

  lazy val codonTableChar = {

    val v = fromFile("data/chapter2/tables/RNA_codon_table_1.txt")

    v.map(s => {
      val ss = s.split(' ')

      if (ss.length == 2) (ss(0), ss(1).charAt(0))
      else (ss(0), null)
    }).toMap

  }

  def mass(p: String): Int = {
    p.foldLeft(0)((i, c) => i + massTable(c))
  }

}

object PUMain extends App {

  println(PeptidUtils.massTable)
}