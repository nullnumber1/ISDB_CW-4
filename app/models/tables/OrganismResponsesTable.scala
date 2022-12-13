package models.tables

import models.OrganismResponse
import models.enums.ResponseTypes
import models.enums.ResponseTypes.ResponseTypes
import slick.ast.BaseTypedType
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcType
import slick.lifted.ProvenShape

/**
 * Table Model of the organisms relation.
 *
 * @param tag The table tag
 */
class OrganismResponsesTable(tag: Tag) extends Table[OrganismResponse](tag, "organisms") {
  implicit val responseTypeMapper: JdbcType[ResponseTypes] with BaseTypedType[ResponseTypes] = MappedColumnType.base[ResponseTypes, String](
    e => e.toString,
    s => ResponseTypes.withName(s)
  )

  def id: Rep[Int] = column[Int]("response_id", O.PrimaryKey, O.AutoInc)

  def rType: Rep[ResponseTypes] = column[ResponseTypes]("response_type")

  def name: Rep[String] = column[String]("name", O.Unique)

  def * : ProvenShape[OrganismResponse] = (id, rType, name) <> ((OrganismResponse.apply _).tupled, OrganismResponse.unapply)
}

object OrganismResponsesTable extends TableQuery[OrganismResponsesTable](new OrganismResponsesTable(_)) {
  /**
   * Place for organisms db methods
   */
}