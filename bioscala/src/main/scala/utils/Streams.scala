package utils

object Streams {

  /**
   * Returns a stream with all the k subpeptids in the dna sequence
   *  Ex. dna = ABC, k = 2
   *  Res = AB, BC
   */
  def dnaStream(dna: String, k: Int): Stream[String] = {
    if (dna.length < k) Stream.Empty else dna.take(k) #:: dnaStream(dna.tail, k)
  }

  val AGCT = List('A', 'G', 'C', 'T')

  def mutations(dna: String): Set[String] = {

    (for {
      i <- 0 until dna.size
      p = dna.take(i)
      c <- AGCT
      if (c != dna.charAt(i))
    } yield p + c + dna.drop(i + 1)).toSet

  }

  def mutations(dnaList: Set[String], d: Int): Set[String] = {

    val cache = new scala.collection.mutable.HashMap[(String, Int), Set[String]]().withDefaultValue(Set())

    def mutationsRec(dna: String, d: Int) {

      if (!cache.contains((dna, d))) {

        val muts = mutations(dna)
        cache.put((dna, d), muts)

        if (d > 1) {
          for (dnam <- mutations(dna)) {
            mutationsRec(dnam, d - 1)
          }
        }
      }
    }

    for (dna <- dnaList) mutationsRec(dna, d)

    cache.values.flatten.toSet

  }

}

