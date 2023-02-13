package Sortie

import Modelisation.{Point, Tondeuse}
import play.api.libs.json.Json

case class OutputClass(limite: Point, tondeuses: List[Tondeuse]) {
  //crée une fonction qui serialize cet objet en json dans un fichier du répertoire resources nommé output.json
  def serialize(): Unit = {
    val json = Json.toJson(this.toString)
    println(json)
  }

}
