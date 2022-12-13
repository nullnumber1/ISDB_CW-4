package models.tables

import models.DumpedSquare
import slick.lifted.ProvenShape
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the square_dump relation.
 *
 * @param tag The table tag
 */
class SquareDumpTable(tag: Tag) extends Table[DumpedSquare](tag, "square_dump") {
  def id: Rep[Int] = column[Int]("square_id", O.PrimaryKey)

  def squareIdConstraint = foreignKey("square_id_fk", id, SquareStackTable)(_.id)

  def * : ProvenShape[DumpedSquare] = id <> (DumpedSquare.apply, DumpedSquare.unapply)
}

object SquareDumpTable extends TableQuery[SquareDumpTable](new SquareDumpTable(_)) {
  /**
   * Place for square_dump db methods
   */
}

