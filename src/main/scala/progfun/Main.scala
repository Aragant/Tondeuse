package fr.esgi.al.funprog

import scala.io.Source.fromFile

object Main {
  def main(args: Array[String]): Unit = {
    val filename = "file.txt"
    val lines = fromFile(filename).getLines.toList
    lines.foreach(println)
  }
}
