package Sortie

import Modelisation.{Point, Tondeuse}
case class OutputClass(limite: Point, tondeuses: List[Tondeuse]) {

  def toJson: String = {
    val tondeusesJson = tondeuses.map { tondeuse =>
      s"""{"position de depart": {"x": ${tondeuse.positionDebut.point.x.toString}, "y": ${tondeuse.positionDebut.point.y.toString}}, "orientation": "${tondeuse.positionDebut.orientation.toString}",
          "position d'Arrivee": {"x": ${tondeuse.positionArrivee.point.x.toString}, "y": ${tondeuse.positionArrivee.point.y.toString}}, "orientation": "${tondeuse.positionArrivee.orientation.toString}"}"""
    }
    s"""{"limite": {"x": ${limite.x.toString}, "y": ${limite.y.toString}}, "tondeuses": [${tondeusesJson
      .mkString(",")}]}"""
  }

  def toCsv: String = {
    val tondeusesCsv = tondeuses.map { tondeuse =>
      s"""${tondeuse.positionDebut.point.x.toString};${tondeuse.positionDebut.point.y.toString};${tondeuse.positionDebut.orientation.toString};${tondeuse.positionArrivee.point.x.toString};${tondeuse.positionArrivee.point.y.toString};${tondeuse.positionArrivee.orientation.toString}\n"""
    }
    s"""numero;debut_x;debut_y;debut_direction;fin_x;fin_y;fin_direction;instructions\n${tondeusesCsv
      .mkString("")}"""
  }
}
