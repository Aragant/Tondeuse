package example

import Modelisation.{Point, Position}
import org.scalatest.funsuite.AnyFunSuite

class PositionSpec extends AnyFunSuite {
  test(
    "Les 2 tondeuses demarrent à la mm position mais pas la meme orientation"
  ) {
    assert(Position(Point(0, 0), 'S') != Position(Point(0, 0), 'N'))
  }
}
