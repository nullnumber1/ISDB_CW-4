package models.tables

import models.GameCell
import slick.lifted.{ProvenShape, Rep}
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the game_field relation.
 *
 * @param tag The table tag
 */
class GameFieldTable(tag: Tag) extends Table[GameCell](tag, "game_field") {
  def id = column[Int]("field_id", O.PrimaryKey, O.AutoInc)

  def xCoordinate = column[Byte]("x_coordinate")

  def yCoordinate = column[Byte]("y_coordinate")

  def cardId = column[Int]("card_id")

  def cardIdConstraint = foreignKey("card_id_fk", cardId, SquareStackTable)(_.id)

  def userId = column[Option[Int]]("user_id")

  def userIdConstraint = foreignKey("user_id_fk", userId, UsersTable)(_.id)

  def diseaseId = column[Option[Int]]("disease_id")

  def diseaseIdConstraint = foreignKey("disease_id_fk", diseaseId, DiseasesTable)(_.id)

  def markerId = column[Option[Int]]("marker_id")

  def markerIdConstraint = foreignKey("marker_id_fk", markerId, ControlMarkersTable)(_.id)

  def * : ProvenShape[GameCell] = (id, xCoordinate, yCoordinate, cardId, userId, diseaseId, markerId) <> ((GameCell.apply _).tupled, GameCell.unapply)
}

object GameFieldTable extends TableQuery[GameFieldTable](new GameFieldTable(_)) {
  /**
   * Place for game_field db methods
   */
}
