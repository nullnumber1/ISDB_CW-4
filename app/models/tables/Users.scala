package models.tables

import models.User
import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the users relation.
 *
 * @param tag The table tag
 */
class Users(tag: Tag) extends Table[User](tag, "users") {
  def username: Rep[String] = column[String]("username")
  def name: Rep[String] = column[String]("name")
  def password: Rep[Option[String]] = column[Option[String]]("password")
  def poAmount: Rep[Int] = column[Int]("po_amount")
  def characterId: Rep[Int] = column[Int]("character_id")
  def xCoordinate: Rep[Byte] = column[Byte]("x_coordinate")
  def yCoordinate: Rep[Byte] = column[Byte]("y_coordinate")
  def * : ProvenShape[User] = (username, name, password, poAmount, characterId, xCoordinate, yCoordinate) <> ((User.apply _).tupled, User.unapply)
}

/**
 * Companion object `Users` for creating a `TableQuery` and
 * creating predefined queries for querying the users relation.
 *
 */
object Users extends TableQuery[Users](new Users(_)) {

  /**
   * Creates query for filtering `User` records by their username.
   *
   * @param username The username of a `User` to find
   * @return An instance of `Query` to perform the aforementioned query against the database
   */
  def filterByUsername(username: String): Query[Users, User, Seq] =
    this.filter(_.username === username)
}
