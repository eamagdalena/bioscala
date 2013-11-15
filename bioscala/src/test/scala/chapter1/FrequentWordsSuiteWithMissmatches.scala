package chapter1

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import chapter1.FrequentWordsWithMissmatches._
import utils.DNAUtils._
import utils.Utils._
import congodb.CongoDAO

@RunWith(classOf[JUnitRunner])
class FrequentWordsWithMissmatchesSuite extends FunSuite {
  //
  //  test("Extra data set") {
  //
  //    assert(solve("CACAGTAGGCGCCGGCACACACAGCCCCGGGCCCCGGGCCGCCCCGGGCCGGCGGCCGCCGGCGCCGGCACACCGGCACAGCCGTACCGGCACAGTAGTACCGGCCGGCCGGCACACCGGCACACCGGGTACACACCGGGGCGCACACACAGGCGGGCGCCGGGCCCCGGGCCGTACCGGGCCGCCGGCGGCCCACAGGCGCCGGCACAGTACCGGCACACACAGTAGCCCACACACAGGCGGGCGGTAGCCGGCGCACACACACACAGTAGGCGCACAGCCGCCCACACACACCGGCCGGCCGGCACAGGCGGGCGGGCGCACACACACCGGCACAGTAGTAGGCGGCCGGCGCACAGCC", 10, 2)
  //      === List("GCACACAGAC", "GCGCACACAC"))
  //
  //  }

  test("Simple with compliments") {
    assert(pretty(solveWithReverseCompliment("ACGTTGCATGTCGCATGATGCATGAGAGCT", 4, 1)) === "ATGT ACAT")
  }

  test("Extra with compliments") {
    assert(pretty(solveWithReverseCompliment("CTTGCCGGCGCCGATTATACGATCGCGGCCGCTTGCCTTCTTTATAATGCATCGGCGCCGCGATCTTGCTATATACGTACGCTTCGCTTGCATCTTGCGCGCATTACGTACTTATCGATTACTTATCTTCGATGCCGGCCGGCATATGCCGCTTTAGCATCGATCGATCGTACTTTACGCGTATAGCCGCTTCGCTTGCCGTACGCGATGCTAGCATATGCTAGCGCTAATTACTTAT", 9, 3)) === "AGCGCCGCT AGCGGCGCT")
  }

}