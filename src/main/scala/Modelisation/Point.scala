package Modelisation

case class Point(x: Int, y: Int) {
  def north: Point = copy(y = y + 1)
  def south: Point = copy(y = y - 1)
  def west: Point = copy(x = x - 1)
  def east: Point = copy(x = x + 1)
}
