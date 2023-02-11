import scala.io.Source

object Input {
    def getLines(filePath: String): List[String] = {
        Source.fromFile(filename).getLines.toList
  }
}