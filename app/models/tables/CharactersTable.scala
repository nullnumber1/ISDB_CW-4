package models.tables

import models.Character
import slick.lifted.{ProvenShape, Rep}
import slick.jdbc.H2Profile.api._

/**
 * Table Model of the characters relation.
 *
 * @param tag The table tag
 */
class CharactersTable(tag: Tag) extends Table[Character](tag, "characters") {
  def id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name: Rep[String] = column[String]("name", O.Unique)
  def moving: Rep[Int] = column[Int]("moving")
  def fight: Rep[Int] = column[Int]("fight")
  def firingRange: Rep[Int] = column[Int]("firing_range")
  def * : ProvenShape[Character] = (id, name, moving, fight, firingRange) <> ((Character.apply _).tupled, Character.unapply)
}

object CharactersTable extends TableQuery[CharactersTable](new CharactersTable(_)) {
  /**
   * Place for characters db methods
   */
}