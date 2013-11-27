package chapter2

import utils.PeptidUtils._

object Subpeptides {

  implicit def pimp(n: Int) = new { def ! = ((1 to n) :\ 1)(_ * _) }

  def computeCombinations(n: Int) = {
    n * (n - 1)
  }

  
  
  def computeSubpeptides(s: String): List[String] = { 

    var res: List[String] = Nil

    for {
      i <- 0 until s.length()
      j <- i + 1 until s.length()
    } {
      res = s.substring(i, j) :: res
      res = (s.substring(j, s.length()) + s.substring(0, i)) :: res
    }

    res
  }

  /* 20 */
  def computeTheoricalSpectrum(peptide: String) = {
    0 :: (mass(peptide) :: computeSubpeptides(peptide).map(mass)).sorted
  }

  def computeTheoricalLinearSpectrum(s: List[Int]): List[Int] = {
    
    var res: List[Int] = Nil

    for {
      i <- 0 until s.size
    } {
      res = s.slice(0, i).sum :: res
      res = s.slice(i, s.size).sum :: res
    }

    (0 :: (s.sum :: res)).sorted
    
    
  }
  
  def computeTheoricalSpectrum(s: List[Int]): List[Int] = { 

    var res: List[Int] = Nil

    for {
      i <- 0 until s.size
      j <- i + 1 until s.size
    } {
      res = s.slice(i, j).sum :: res
      res = (s.slice(j, s.size) ++ s.slice(0, i)).sum :: res
    }

    (0 :: (s.sum :: res)).sorted 
  }

  
  val cache = new scala.collection.mutable.HashMap[Int, Long]().withDefaultValue(-1)

  /* 21 */
  def computeNumberPeptids(targetMass: Int): Long = {

    val cached = cache(targetMass)

    if (cached != -1) {
      cached
    } else {

      val res = massList.foldLeft(0L)(
        (i, d) => {

          val m = targetMass - d._2

          if (m == 0) i + 1
          else if (m < 0) i
          else i + computeNumberPeptids(m)

        })
      cache.put(targetMass, res)
      res
    }
  }

}

object SubpeptidesMain extends App {
  //println(Subpeptides.computeTheoricalSpectrum("GHKAFEVTDGEGK").mkString(" "))

  println(Subpeptides.computeCombinations(17668))

  //println(Subpeptides.computeNumberPeptids(1496))

}
