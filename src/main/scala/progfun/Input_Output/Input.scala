package progfun.Input_Output

import scala.io.Source.fromFile

object InputParser {
  def getFileLine(filePath: String): List[String] = {
    val lines = fromFile(filePath).getLines().toList
    lines.foreach { line =>
      line.replace(" ", "")
    }
    lines
  }

  def parseText(text: String): List[String] = {
    val lines = text.split(" ").map(_.trim)
    lines.toList
  }
}
