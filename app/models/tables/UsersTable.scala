package models.tables

import models.User
import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the users relation.
 *
 * @param tag The table tag
 */
class UsersTable(tag: Tag) extends Table[User](tag, "users") {
  def id: Rep[Int] = column[Int]("user_id", O.PrimaryKey, O.AutoInc)
  def username: Rep[String] = column[String]("username")

  def password: Rep[Option[String]] = column[Option[String]]("password")

  def poAmount: Rep[Option[Int]] = column[Int]("po_amount")

  def characterId: Rep[Option[Int]] = column[Int]("character_id")

  def characterIdConstraint = foreignKey("character_id_fk", characterId, CharactersTable)(_.id)

  def xCoordinate: Rep[Option[Byte]] = column[Byte]("x_coordinate")

  def yCoordinate: Rep[Option[Byte]] = column[Byte]("y_coordinate")

  def * : ProvenShape[User] = (username, password, poAmount, characterId, xCoordinate, yCoordinate) <> ((User.apply _).tupled, User.unapply)
}

/**
 * Companion object `Users` for creating a `TableQuery` and
 * creating predefined queries for querying the users relation.
 *
 */
object UsersTable extends TableQuery[UsersTable](new UsersTable(_)) {

  /**
   * Creates query for filtering `User` records by their username.
   *
   * @param username The username of a `User` to find
   * @return An instance of `Query` to perform the aforementioned query against the database
   */
  def filterByUsername(username: String): Query[UsersTable, User, Seq] =
    this.filter(_.username === username)
}
