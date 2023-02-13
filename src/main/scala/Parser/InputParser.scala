package Parser

import scala.io.Source.fromFile

object InputParser {
  @throws(classOf[DonneesIncorrectException])
  def getFileLine(filePath: String): List[String] = {
    val lines = fromFile(filePath).getLines().toList.map(_.replace(" ", ""))

    /*if (lines.size != 5) {
      throw new DonneesIncorrectException(
        "Le fichier est invalide car il n'y a pas EXACTEMENT 5 lignes."
      )
    } else {
      lines.foreach { line =>
        line.replace(" ", "")
      }
    }
     */
    lines
  }

  def parseText(text: String): List[String] = {
    val lines = text.split(" ").map(_.trim)
    lines.toList
  }
}
