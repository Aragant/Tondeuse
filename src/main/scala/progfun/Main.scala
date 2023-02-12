package fr.esgi.al.funprog

import com.typesafe.config.{Config, ConfigFactory}
import fr.esgi.al.funprog.Hello.Greeting
import progfun.Input_Output.InputParser

import scala.io.StdIn

object Hello extends Greeting with App {
  println(":> Enter your name: ")
  val user = StdIn.readLine()
  println(s":> $greeting $user")

  val conf: Config = ConfigFactory.load()
  val message: String = conf.getString("example.message")
  println(s":> message: $message")
  val one: Int = conf.getInt("example.one")
  println(s":> one: ${one.toString}")
  val yes: Boolean = conf.getBoolean("example.yes")
  println(s":> yes: ${yes.toString}")

  val lines = InputParser.getFileLine(
    "src/main/scala/progfun/Input_Output/texteInput.txt"
  )
  lines.foreach { line =>
    println(line)
  }

  trait Greeting {
    lazy val greeting: String = "hello"

    case class MyException(msg: String) extends Exception

    @SuppressWarnings(Array("org.wartremover.warts.Throw"))
    def dangerous(): Unit = {
      throw new MyException("boooom")
    }
  }
}
