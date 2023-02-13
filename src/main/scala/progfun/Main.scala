package progfun

import Modelisation.{Point, Position, Tondeuse}
import Parser.InputParser
import com.typesafe.config.{Config, ConfigFactory}
import Sortie.{OutputClass}

object Main extends App {

  val conf: Config = ConfigFactory.load()

  val filePath = "src/main/resources/texteInput.txt"
  val lines = InputParser.getFileLine(filePath)
  lines.foreach { line =>
    println(line)
  }

  val limite: Point =
    Point(lines(0)(0).toString.toInt, lines(0)(1).toString.toInt)
  println(limite.toString)

  val positionDebutTondeuse1: Position = Position(
    Point(lines(1)(0).toString.toInt, lines(1)(1).toString.toInt),
    lines(1)(2).toString.charAt(0)
  )
  println(positionDebutTondeuse1.toString)

  val instructionsTondeuse1: String = lines(2)
  println(instructionsTondeuse1)

  val positionDebutTondeuse2: Position = Position(
    Point(lines(3)(0).toString.toInt, lines(3)(1).toString.toInt),
    lines(3)(2).toString.charAt(0)
  )
  println(positionDebutTondeuse2.toString)

  val instructionsTondeuse2: String = lines(4)
  println(instructionsTondeuse2)

  val tondeuse1 = Tondeuse(
    positionDebutTondeuse1,
    instructionsTondeuse1.toList,
    positionDebutTondeuse1
  )

  val tondeuse2 = Tondeuse(
    positionDebutTondeuse2,
    instructionsTondeuse2.toList,
    positionDebutTondeuse2
  )

  val jsonOutput = OutputClass(limite, List(tondeuse1, tondeuse2))
  jsonOutput.serialize()

}
