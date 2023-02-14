package Sortie

import Modelisation.{Point, Tondeuse}

import java.io.{File, PrintWriter}

case class OutputClass(limite: Point, tondeuses: List[Tondeuse]) {

  def toJson: String = {
    val tondeusesJson = tondeuses.map { tondeuse =>
      s"""{\n\t\t\t"position de depart":\n\t\t\t{\n\t\t\t\t"point":\n\t\t\t\t{\n\t\t\t\t\t"x": ${tondeuse.positionDebut.point.x.toString},\n\t\t\t\t\t"y": ${tondeuse.positionDebut.point.y.toString}\n\t\t\t\t},\n\t\t\t\t"orientation": "${tondeuse.positionDebut.orientation.toString}"\n\t\t\t},\n\t\t\t"instructions": ["${tondeuse.instructions
        .mkString("\",\"")}"],\n\t\t\t"position d'Arrivee":\n\t\t\t{\n\t\t\t\t"point":\n\t\t\t\t{\n\t\t\t\t\t"x": ${tondeuse.positionArrivee.point.x.toString},\n\t\t\t\t\t"y": ${tondeuse.positionArrivee.point.y.toString}\n\t\t\t\t},\n\t\t\t\t"orientation": "${tondeuse.positionArrivee.orientation.toString}"\n\t\t\t}\n\t\t}"""
    }
    s"""{\n\t"limite":\n\t{\n\t\t"x": ${limite.x.toString},\n\t\t"y": ${limite.y.toString}\n\t},\n\t"tondeuses":\n\t[\n\t\t${tondeusesJson
      .mkString(",\n\t\t")}\n\t]\n}"""
  }

  def writeJson(filepath: String): Unit = {
    val pw = new PrintWriter(new File(filepath))
    pw.write(toJson)
    pw.close()
  }
  def toCsv: String = {
    val tondeusesCsv = tondeuses.zip(1 to tondeuses.size).map {
      case (tondeuse, index) =>
        s"""${index.toString};${tondeuse.positionDebut.point.x.toString};${tondeuse.positionDebut.point.y.toString};${tondeuse.positionDebut.orientation.toString};${tondeuse.positionArrivee.point.x.toString};${tondeuse.positionArrivee.point.y.toString};${tondeuse.positionArrivee.orientation.toString};${tondeuse.instructions.mkString}\n"""
    }
    s"""numero;debut_x;debut_y;debut_direction;fin_x;fin_y;fin_direction;instructions\n${tondeusesCsv
      .mkString("")}"""
  }

  def writeCsv(filepath: String): Unit = {
    val pw = new PrintWriter(new File(filepath))
    pw.write(toCsv)
    pw.close()
  }

  def toYAML: String = {
    val tondeusesYAML = tondeuses.map { tondeuse =>
      s"""- position de depart:
         |    point:
         |      x: ${tondeuse.positionDebut.point.x.toString}
         |      y: ${tondeuse.positionDebut.point.y.toString}
         |    orientation: ${tondeuse.positionDebut.orientation.toString}
         |  instructions: \n  -${tondeuse.instructions
           .map(_.toString)
           .mkString("\n  - ")}
         |  position d'Arrivee:
         |    point:
         |      x: ${tondeuse.positionArrivee.point.x.toString}
         |      y: ${tondeuse.positionArrivee.point.y.toString}
         |    orientation: ${tondeuse.positionArrivee.orientation.toString}""".stripMargin
    }
    s"""limite:
       |  x: ${limite.x.toString}
       |  y: ${limite.y.toString}
       |tondeuses:
       |${tondeusesYAML.mkString("\n")}""".stripMargin
  }

  def writeYAML(filepath: String): Unit = {
    val pw = new PrintWriter(new File(filepath))
    pw.write(toYAML)
    pw.close()
  }
}
