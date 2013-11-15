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

  def mass(p: String): Int = {
    p.foldLeft(0)((i, c) => i + massTable(c))
  }

}

object PUMain extends App {

  println(PeptidUtils.massTable)
}