package models.tables;

import models.SquareShape
import models.enums.ShapeTypes
import models.enums.ShapeTypes.ShapeTypes
import slick.ast.BaseTypedType
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcType
import slick.lifted.ProvenShape

/**
 * Table Model of the square_shape relation
 *
 * @param tag The table tag
 */
class SquareShapeTable(tag: Tag) extends Table[SquareShape](tag, "square_shape") {
  implicit val responseTypeMapper: JdbcType[ShapeTypes] with BaseTypedType[ShapeTypes] = MappedColumnType.base[ShapeTypes, String](
    e => e.toString,
    s => ShapeTypes.withName(s)
  )

  def id = column[Int]("shape_id", O.PrimaryKey, O.AutoInc)

  def sType: Rep[ShapeTypes] = column[ShapeTypes]("shape_name")

  def * = (id, sType) <> ((SquareShape.apply _).tupled, SquareShape.unapply)
}

/**
 * Companion object of `SquareShapeTable`, full of util methods for the class including JSON conversions.
 */
object SquareShapeTable extends TableQuery[SquareShapeTable](new SquareShapeTable(_)) {
  /**
   * Place for square_shape db methods
   */
}


