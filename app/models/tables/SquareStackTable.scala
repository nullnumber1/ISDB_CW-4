package models.tables

import models.Square
import slick.jdbc.H2Profile.api._
import slick.lifted.{ProvenShape, Tag}

import scala.concurrent.Future

class SquareStackTable(tag: Tag) extends Table[Square](tag, "square_stack") {
  def id = column[Int]("card_id", O.PrimaryKey, O.AutoInc)

  def name = column[String]("name")

  def poAmount = column[Byte]("po_amount")

  def shapeId = column[Int]("shape_id")

  def shape_idConstraint = foreignKey("shape_id_fk", shapeId, SquareShapeTable)(_.id)

  def objectId: Rep[Int] = column[Int]("object_id")

  def object_idConstraint = foreignKey("object_id_fk", objectId, SquareObjectTable)(_.id)

  def actionId: Rep[Option[Int]] = column[Option[Int]]("action_id")

  def action_idConstraint = foreignKey("action_id_fk", actionId, SquareActionTable)(_.id)

  def conditionId: Rep[Option[Int]] = column[Option[Int]]("condition_id")

  def condition_idConstraint = foreignKey("condition_id_fk", conditionId, SquareConditionTable)(_.id)

  def * : ProvenShape[Square] = (id, name, poAmount, shapeId, objectId, actionId, conditionId) <> ((Square.apply _).tupled, Square.unapply)
}

object SquareStackTable extends TableQuery[SquareStackTable](new SquareStackTable(_)) {
  def filterById(id: Int): Query[SquareStackTable, Square, Seq] = this.filter(_.id === id)

  def findByName(name: String): Query[SquareStackTable, Square, Seq] = {
    this.filter(_.name === name)
  }
}
