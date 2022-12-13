package models.tables

import models.Disease
import slick.lifted.{ProvenShape, Rep}
import slick.jdbc.H2Profile.api._

class DiseasesTable(tag: Tag) extends Table[Disease](tag, "diseases") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)

  def name = column[String]("name", O.Unique)

  def poReward = column[Byte]("po_reward")

  def squareReward = column[Option[Byte]]("square_reward")

  def xCoordinate = column[Option[Byte]]("x_coordinate")

  def yCoordinate = column[Option[Byte]]("y_coordinate")

  def * : ProvenShape[Disease] = (id, name, poReward, squareReward, xCoordinate, yCoordinate) <> ((Disease.apply _).tupled, Disease.unapply)
}

object DiseasesTable extends TableQuery[DiseasesTable](new DiseasesTable(_)) {
  /**
   * Place for diseases db methods
   */
}
