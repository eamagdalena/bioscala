package chapter2

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import chapter2.LeaderboardCyclopeptideSequencing._
import utils.Utils._

@RunWith(classOf[JUnitRunner])
class LeaderboardCycloPeptideSequencingSuite extends FunSuite {

  test("test extra data set") {

    val v = fromFile("data/chapter2/leaderboard_data.txt")

    val spectrum = v(2).split(" ").toList.map(_.toInt)

    println("perfect mass " + spectrum.last)

    val calculatedSolution = solve(v(1).toInt, spectrum)

    println("calculated mass " + calculatedSolution.sum)
    
    val expectedSolution = v(4).split("-").toList.map(_.toInt)

    println("expected mass " + expectedSolution.sum)
    
    
    assert(calculatedSolution.sorted === expectedSolution.sorted)

  }

}