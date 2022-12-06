package models.tables

import models.Character
import slick.lifted.{ProvenShape, Rep}
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the characters relation.
 *
 * @param tag The table tag
 */
class Characters(tag: Tag) extends Table[Character](tag, "characters") {
  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name: Rep[String] = column[String]("name")
  def moving: Rep[Int] = column[Int]("moving")
  def fight: Rep[Int] = column[Int]("fight")
  def firingRange: Rep[Int] = column[Int]("firing_range")
  def * : ProvenShape[Character] = (id, name, moving, fight, firingRange) <> ((Character.apply _).tupled, Character.unapply)
}

object Characters extends TableQuery[Characters](new Characters(_)) {
  /**
   * Place for characters db methods
   */
}