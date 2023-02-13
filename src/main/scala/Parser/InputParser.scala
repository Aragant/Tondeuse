package Parser

import scala.io.Source.fromFile

object InputParser {
  //@throws(classOf[DonneesIncorrectException])
  def getFileLine(filePath: String): List[String] = {
    val lines = fromFile(filePath).getLines().toList.map(_.replace(" ", ""))
    lines
  }
}
