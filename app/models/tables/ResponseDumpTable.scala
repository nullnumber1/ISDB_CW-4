package models.tables

import models.ResponseDump
import slick.lifted.ProvenShape
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the response_dump relation.
 *
 * @param tag The table tag
 */
class ResponseDumpTable(tag: Tag) extends Table[ResponseDump](tag, "response_dump") {
  def responseId: Rep[Int] = column[Int]("response_id", O.PrimaryKey)

  def responseIdConstraint = foreignKey("response_id_fk", responseId, OrganismResponsesTable)(_.id)

  def * : ProvenShape[ResponseDump] = responseId <> (ResponseDump.apply, ResponseDump.unapply)
}

object ResponseDumpTable extends TableQuery[ResponseDumpTable](new ResponseDumpTable(_)) {
  /**
   * Place for response_dump db methods
   */
}
