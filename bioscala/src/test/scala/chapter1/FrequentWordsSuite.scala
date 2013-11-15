package chapter1

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import chapter1.FrequentWords._
import utils.DNAUtils
import utils.Utils
import congodb.CongoDAO

@RunWith(classOf[JUnitRunner])
class FrequentWordsSuite extends FunSuite {

  test("Thermotoga petrophila") {
    //assert(solve(CongoDAO.findGenome("Thermotoga-petrophila"), 9) === "AACCTACCA AAACCTACC ACCTACCAC CCTACCACC GGTAGGTTT TGGTAGGTT")
    assert(solve(Utils.fromFile("data/genomes/Thermotoga-petrophila.txt").head, 9) === "AACCTACCA AAACCTACC ACCTACCAC CCTACCACC GGTAGGTTT TGGTAGGTT")
  }

}