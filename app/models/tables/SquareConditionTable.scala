package models.tables

import models.SquareCondition
import models.enums.ConditionTypes
import models.enums.ConditionTypes.ConditionTypes
import slick.ast.BaseTypedType
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcType
import slick.lifted.ProvenShape

/**
 * Table Model of the square_condition relation.
 *
 * @param tag The table tag
 */
class SquareConditionTable(tag: Tag) extends Table[SquareCondition](tag, "square_condition") {
  implicit val responseTypeMapper: JdbcType[ConditionTypes] with BaseTypedType[ConditionTypes] = MappedColumnType.base[ConditionTypes, String](
    e => e.toString,
    s => ConditionTypes.withName(s)
  )

  def id: Rep[Int] = column[Int]("condition_id", O.PrimaryKey, O.AutoInc)

  def aType: Rep[ConditionTypes] = column[ConditionTypes]("condition_name")

  def * : ProvenShape[SquareCondition] = (id, aType) <> ((SquareCondition.apply _).tupled, SquareCondition.unapply)
}

/**
 * Companion object of `SquareConditionTable`, full of util methods for the class including JSON conversions.
 */
object SquareConditionTable extends TableQuery[SquareConditionTable](new SquareConditionTable(_)) {
  /**
   * Place for square_condition db methods
   */
}