package chapter1

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import chapter1.Skew._
import utils.DNAUtils
import utils.Utils._
import congodb.CongoDAO

@RunWith(classOf[JUnitRunner])
class SkewSuite extends FunSuite {

  test("Simple") {
    assert(solve("CATGGGCATCGGCCATACGCC").toList === List(0, -1, -1, -1, 0, 1, 2, 1, 1, 1, 0, 1, 2, 1, 0, 0, 0, 0, -1, 0, -1, -2))
  }

  test("Simple Solve Min") {
    assert(solveMin("TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT") === List(11, 24))
  }

  test("Solve Min") {

    solveSimple("data/chapter1/dataset7.txt", solveMin _ andThen pretty _)

    assert(fromFile("data/chapter1/dataset7.txt.solved.txt").head === "89969 89970 89971 90345 90346")

  }

  test("Solve E-Coli") {
    assert(solveMin((fromFile("data/genomes/E-coli.txt").head)).head === 3923620)
  }

}