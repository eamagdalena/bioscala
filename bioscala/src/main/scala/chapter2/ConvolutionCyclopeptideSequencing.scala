package chapter2

import utils.PeptidUtils.massOnlyList

object ConvolutionCyclopeptideSequencing {

  type Spectrum = List[Int]
  
  
  def solve(M : Int, N : Int, spectrum : Spectrum) = {
    
    val convolution = SpectralConvolution.solve(spectrum)
    .filter(x => x >= 57 && x <= 200)
    .groupBy(x => x)
    .toList
    .map(x => (x._1, x._2.length) )
    .sortBy(x => -x._2)
    
    println(convolution)
   
    val leaders = convolution.take(M) 
    
    lazy val lastScore = leaders.last._2

    val ties = convolution.drop(M).takeWhile(_._2 == lastScore)
    
    println(lastScore)
    
    println(leaders)
    println(ties)
    
    val leaderboardAlgo = new LeaderboardCyclopeptideSequencing(N, spectrum, (leaders ++ ties).map(_._1)) //.filter(massOnlyList.contains(_))

    leaderboardAlgo.solveMe
        
  }
  
}

object CCSMain extends App{

  println (ConvolutionCyclopeptideSequencing.solve(20, 60, List(57, 57, 71, 99, 129, 137, 170, 186, 194, 208, 228, 265, 285, 299, 307, 323, 356, 364, 394, 422, 493)))

     
  
}