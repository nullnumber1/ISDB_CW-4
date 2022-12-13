package models.tables

import models.DumpedResponse
import slick.lifted.ProvenShape
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the response_dump relation.
 *
 * @param tag The table tag
 */
class ResponseDumpTable(tag: Tag) extends Table[DumpedResponse](tag, "response_dump") {
  def id: Rep[Int] = column[Int]("response_id", O.PrimaryKey)

  def responseIdConstraint = foreignKey("response_id_fk", id, OrganismResponsesTable)(_.id)

  def * : ProvenShape[DumpedResponse] = id <> (DumpedResponse.apply, DumpedResponse.unapply)
}

object ResponseDumpTable extends TableQuery[ResponseDumpTable](new ResponseDumpTable(_)) {
  /**
   * Place for response_dump db methods
   */
}
