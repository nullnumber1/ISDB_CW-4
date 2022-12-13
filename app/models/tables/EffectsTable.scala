package models.tables

import models.Effect
import slick.lifted.{ProvenShape, Tag}
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the effects relation.
 *
 * @param tag The table tag
 */
class EffectsTable(tag: Tag) extends Table[Effect](tag, "effects") {
  def id: Rep[Int] = column[Int]("effect_id", O.PrimaryKey, O.AutoInc)

  def userId: Rep[Int] = column[Int]("user_id")

  def userIdConstraint = foreignKey("user_id_fk", userId, UsersTable)(_.id)

  def responseId: Rep[Int] = column[Int]("response_id")

  def responseIdConstraint = foreignKey("response_id_fk", responseId, OrganismResponsesTable)(_.id)

  def * : ProvenShape[Effect] = (id, userId, responseId) <> ((Effect.apply _).tupled, Effect.unapply)

}

object EffectsTable extends TableQuery[EffectsTable](new EffectsTable(_)) {
  /**
   * Place for effects db methods
   */
}
