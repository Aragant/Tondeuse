package example

import Modelisation.Point
import org.scalatest.funsuite.AnyFunSuite

class PointSpec extends AnyFunSuite {
  test("Point(1,2) == Point(1,2)") {
    assert(Point(1, 2) == Point(1, 2))
  }

  test("Avancer Point(1,2) vers le nord renvoie Point(1,3)") {
    assert(Point(1, 2).north == Point(1, 3))
  }

  test("Avancer Point(0,0) vers le sud renvoie Point(0,0)") {
    assert(Point(0, 0).south == Point(0, 0))
  }
}
