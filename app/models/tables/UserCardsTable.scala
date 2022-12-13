package models.tables

import models.UserCard
import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.H2Profile.api._

class UserCardsTable(tag: Tag) extends Table[UserCard](tag, "user_cards") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def userId = column[Int]("user_id")

  def userIdConstraint = foreignKey("user_id_fk", userId, UsersTable)(_.id)

  def cardId = column[Int]("card_id")

  def cardIdConstraint = foreignKey("card_id_fk", cardId, SquareStackTable)(_.id)

  def * = (id, userId, cardId) <> ((UserCard.apply _).tupled, UserCard.unapply)
}

object UserCardsTable extends TableQuery[UserCardsTable](new UserCardsTable(_)) {
  /**
   * Place for user_cards db methods
   */
}
