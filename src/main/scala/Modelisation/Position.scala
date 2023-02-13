package Modelisation

case class Position(point: Point, orientation: Char) {
  def avancer(): Position = {
    orientation match {
      case 'N' => copy(point = point.north)
      case 'S' => copy(point = point.south)
      case 'E' => copy(point = point.east)
      case 'W' => copy(point = point.west)
    }
  }

  def turnLeft(): Position = {
    orientation match {
      case 'N' => copy(orientation = 'W')
      case 'S' => copy(orientation = 'E')
      case 'E' => copy(orientation = 'N')
      case 'W' => copy(orientation = 'S')
    }
  }

  def turnRight(): Position = {
    orientation match {
      case 'N' => copy(orientation = 'E')
      case 'S' => copy(orientation = 'W')
      case 'E' => copy(orientation = 'S')
      case 'W' => copy(orientation = 'N')
    }
  }
}
