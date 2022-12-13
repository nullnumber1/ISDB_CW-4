package models.tables

import models.SquareObject
import models.enums.ObjectTypes
import models.enums.ObjectTypes.ObjectTypes
import slick.ast.BaseTypedType
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcType
import slick.lifted.ProvenShape

/**
 * Table Model of the square_object relation.
 *
 * @param tag The table tag
 */
class SquareObjectTable(tag: Tag) extends Table[SquareObject](tag, "object_type") {
  implicit val responseTypeMapper: JdbcType[ObjectTypes] with BaseTypedType[ObjectTypes] = MappedColumnType.base[ObjectTypes, String](
    e => e.toString,
    s => ObjectTypes.withName(s)
  )

  def id: Rep[Int] = column[Int]("object_id", O.PrimaryKey, O.AutoInc)

  def oType: Rep[ObjectTypes] = column[ObjectTypes]("object_name")

  def * : ProvenShape[SquareObject] = (id, oType) <> ((SquareObject.apply _).tupled, SquareObject.unapply)
}

/**
 * Companion object of `ObjectTypeTable`, full of util methods for the class including JSON conversions.
 */
object SquareObjectTable extends TableQuery[SquareObjectTable](new SquareObjectTable(_)) {
  /**
   * Place for object_type db methods
   */
}