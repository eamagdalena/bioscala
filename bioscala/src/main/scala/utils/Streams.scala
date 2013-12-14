package utils

object Streams {

  /** Returns a stream with all the k subpeptids in the dna sequence
   *  Ex. dna = ABC, k = 2
   *  Res = AB, BC
   */
  def dnaStream(dna: String, k: Int): Stream[String] = {
    if (dna.length < k) Stream.Empty else dna.take(k) #:: dnaStream(dna.tail, k)
  }
  
  
  
}