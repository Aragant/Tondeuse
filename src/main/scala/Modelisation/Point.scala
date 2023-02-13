package Modelisation

case class Point(x: Int, y: Int) {
  def north: Point = copy(x = x + 1)
  def south: Point = copy(x = x - 1)
  def west: Point = copy(y = y - 1)
  def east: Point = copy(y = y + 1)
}
