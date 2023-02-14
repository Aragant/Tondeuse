package progfun

import Modelisation.{Point, Tondeuse}
import Parser.InputParser
import Sortie.OutputClass
import com.typesafe.config.{Config, ConfigFactory}

object Main extends App {

  val conf: Config = ConfigFactory.load()

  val lines = InputParser.getFileLine(conf.getString("application.input-file"))

  val limite: Point =
    Point(lines(0)(0).toString.toInt, lines(0)(1).toString.toInt)

  val tondeuses: List[Tondeuse] = InputParser.getTondeuses(lines.drop(1))

  val outputClass = OutputClass(limite, tondeuses)
  outputClass.writeJson(conf.getString("application.output-json-file"))
  outputClass.writeCsv(conf.getString("application.output-csv-file"))
  outputClass.writeYAML(conf.getString("application.output-yaml-file"))
}
