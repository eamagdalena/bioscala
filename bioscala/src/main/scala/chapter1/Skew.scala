package chapter1

import utils.Utils._

object Skew {

  type Genome = String

  def solve(g: Genome) = {

    var dif: Int = 0

    0 :: g.map(c => {
      dif = dif + (if (c == 'G') 1 else if (c == 'C') -1 else 0)
      dif
    }).toList

  }

  def solveMin(g: Genome) = {

    var min = Integer.MAX_VALUE
    var pos = -1

    solve(g).foldLeft(List[Int]())((l, x) => {
      pos = pos + 1

      if (x < min) {
        min = x
        List(pos)
      } else if (x == min) {
        l :+ pos
      } else l

    })

  }

  def prettySolveMin(g: Genome) = {
    pretty(solveMin(g))
  }

}

object MainSkew extends App {

  solveSimple("data/chapter1/dataset_7_6.txt", Skew.prettySolveMin)

}