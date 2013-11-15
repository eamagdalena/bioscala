package congodb

import com.mongodb.casbah.Imports._
import utils.Utils

object CongoDAO {

  val client = MongoClient()

  def storeGenome(name: String, genome: String) =
    client("bioscala")("genomes").insert(MongoDBObject("_id" -> name, "name" -> name, "genome" -> genome))

  def findGenome(name: String) =
    client("bioscala")("genomes").findOne(MongoDBObject("_id" -> name)).get.apply("genome").toString()

}

object CongoMain extends App {
  //CongoDAO.storeGenome("Thermotoga-petrophila", Utils.fromFile("data/genomes/Thermotoga-petrophila.txt").head)
  //CongoDAO.storeGenome("Vibrio_cholerae", Utils.fromFile("data/genomes/Vibrio_cholerae.txt").head)

  println(CongoDAO.findGenome("Thermotoga-petrophila"))
}