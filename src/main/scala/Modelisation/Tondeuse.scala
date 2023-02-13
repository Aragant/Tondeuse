package Modelisation

case class Tondeuse(
    positionDebut: Position,
    instructions: List[Char],
    positionArrivee: Position
) {

  def this(positionDebut: Position, instructions: List[Char]) =
    this(positionDebut, instructions, positionDebut)

  def this(positionDebut: Position) = this(positionDebut, List(), positionDebut)

  //def this() = this(new Position(new Point(0,0), "N"))

}
