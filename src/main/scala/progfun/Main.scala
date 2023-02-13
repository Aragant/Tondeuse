package progfun

import Modelisation.{Point, Position, Tondeuse}
import Parser.InputParser
import com.typesafe.config.{Config, ConfigFactory}
import Sortie.OutputClass

object Main extends App {

  val conf: Config = ConfigFactory.load()

  val lines = InputParser.getFileLine(conf.getString("application.input-file"))
  lines.foreach { line =>
    println(line)
  }

  val limite: Point =
    Point(lines(0)(0).toString.toInt, lines(0)(1).toString.toInt)
  println(limite.toString)

  for (i <- 1 until lines.length by 2) {
    val positionDebutTondeuse: Position = Position(
      Point(lines(i)(0).toString.toInt, lines(i)(1).toString.toInt),
      lines(i)(2).toString.charAt(0)
    )
    println(positionDebutTondeuse.toString)

    val instructionsTondeuse: String = lines(i + 1)
    println(instructionsTondeuse)

    val tondeuse = Tondeuse(
      positionDebutTondeuse,
      instructionsTondeuse.toList,
      positionDebutTondeuse
    ).run(instructionsTondeuse.toList)

    println("position Debut tondeuse = " + tondeuse.positionDebut.toString)
    println("position Arrivee tondeuse = " + tondeuse.positionArrivee.toString)
  }
  val positionDebutTondeuse1: Position = Position(
    Point(lines(1)(0).toString.toInt, lines(1)(1).toString.toInt),
    lines(1)(2).toString.charAt(0)
  )

  val instructionsTondeuse1: String = lines(2)

  val positionDebutTondeuse2: Position = Position(
    Point(lines(3)(0).toString.toInt, lines(3)(1).toString.toInt),
    lines(3)(2).toString.charAt(0)
  )

  val instructionsTondeuse2: String = lines(4)

  val tondeuse1 = Tondeuse(
    positionDebutTondeuse1,
    instructionsTondeuse1.toList,
    positionDebutTondeuse1
  ).run(instructionsTondeuse1.toList)

  println("position Debut tondeuse 1 = " + tondeuse1.positionDebut.toString)
  println("position Arrivee tondeuse 1 = " + tondeuse1.positionArrivee.toString)

  val tondeuse2 = Tondeuse(
    positionDebutTondeuse2,
    instructionsTondeuse2.toList,
    positionDebutTondeuse2
  ).run(instructionsTondeuse2.toList)

  println("position Debut Tondeuse 2 = " + tondeuse2.positionDebut.toString)
  println("position Arrivee tondeuse 2 = " + tondeuse2.positionArrivee.toString)

  val outputClass = OutputClass(limite, List(tondeuse1, tondeuse2))
  outputClass.writeJson(conf.getString("application.output-json-file"))
  outputClass.writeCsv(conf.getString("application.output-csv-file"))
}
