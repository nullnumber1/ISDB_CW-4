package models.tables

import models.SquareAction
import models.enums.ActionTypes
import models.enums.ActionTypes.ActionTypes
import slick.ast.BaseTypedType
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcType

/**
 * Table for square actions.
 *
 * @param tag Database tag
 */
class SquareActionTable(tag: Tag) extends Table[SquareAction](tag, "square_action") {
  implicit val responseTypeMapper: JdbcType[ActionTypes] with BaseTypedType[ActionTypes] = MappedColumnType.base[ActionTypes, String](
    e => e.toString,
    s => ActionTypes.withName(s)
  )

  def id = column[Int]("action_id", O.PrimaryKey, O.AutoInc)

  def aType = column[ActionTypes.ActionTypes]("action_name")

  def * = (id, aType) <> ((SquareAction.apply _).tupled, SquareAction.unapply)
}

object SquareActionTable extends TableQuery[SquareActionTable](new SquareActionTable(_)) {
  /**
   * Place for square_action db methods
   */
}

