package Parser

import Modelisation.{Point, Position, Tondeuse}

import scala.io.Source.fromFile

object InputParser {
  //@throws(classOf[DonneesIncorrectException])
  def getFileLine(filePath: String): List[String] = {
    val lines = fromFile(filePath).getLines().toList.map(_.replace(" ", ""))
    lines
  }

  def getTondeuses(lines: List[String]): List[Tondeuse] = {
    val tondeuse = lines
      .grouped(2)
      .map {
        case List(position, instructions) =>
          val positionTondeuse: Position = Position(
            Point(position(0).toString.toInt, position(1).toString.toInt),
            position(2).toString.charAt(0)
          )
          Tondeuse(positionTondeuse, instructions.toList, positionTondeuse).run(
            instructions.toList
          )
      }
      .toList
    tondeuse
  }
}
