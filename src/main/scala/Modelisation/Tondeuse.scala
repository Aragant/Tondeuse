package Modelisation

import scala.annotation.tailrec

case class Tondeuse(
    positionDebut: Position,
    instructions: List[Char],
    positionArrivee: Position
) {

  def this(positionDebut: Position, instructions: List[Char]) =
    this(positionDebut, instructions, positionDebut)

  def this(positionDebut: Position) = this(positionDebut, List(), positionDebut)

  def avancer(): Tondeuse = {
    val newPosition = positionArrivee.avancer()
    this.copy(positionArrivee = newPosition)
  }

  def tournerGauche(): Tondeuse = {
    val newPosition = positionArrivee.turnLeft()
    this.copy(positionArrivee = newPosition)
  }

  def tournerDroite(): Tondeuse = {
    val newPosition = positionArrivee.turnRight()
    this.copy(positionArrivee = newPosition)
  }
  @tailrec
  final def run(instructions: List[Char]): Tondeuse = {
    instructions match {
      case Nil => this
      case head :: tail =>
        head match {
          case 'A' => this.avancer().run(tail)
          case 'G' => this.tournerGauche().run(tail)
          case 'D' => this.tournerDroite().run(tail)
        }
    }
  }

}
