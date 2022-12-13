package models.tables

import models.ControlMarker
import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the control_markers relation.
 *
 * @param tag The table tag
 */
class ControlMarkersTable(tag: Tag) extends Table[ControlMarker](tag, "control_markers") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def userId = column[Int]("user_id")

  def userIdConstraint = foreignKey("user_id_fk", userId, UsersTable)(_.id)

  def amount = column[Byte]("amount")

  def * : ProvenShape[ControlMarker] = (id, userId, amount) <> ((ControlMarker.apply _).tupled, ControlMarker.unapply)
}

object ControlMarkersTable extends TableQuery[ControlMarkersTable](new ControlMarkersTable(_)) {
  /**
   * Place for control_markers db methods
   */
}
