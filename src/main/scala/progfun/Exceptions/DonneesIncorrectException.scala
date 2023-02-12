package fr.esgi.al.funprog
package Exceptions

final case class DonneesIncorrectException(message: String)
    extends Exception(message) {
  def this() = this("Données incorrectes")
}
