package models.dao

import models.Square
import models.tables.SquareStackTable
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class SquareStackDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {
  import profile.api._

  def getAll: Future[Seq[Square]] = db.run(SquareStackTable.result)

  /**
   * Finds `SquareStack` entity using the stack id. Returns None if not found.
   *
   * @param id Stack id
   * @return `SquareStack` entity from database
   */
  def findById(id: Int): Future[Option[Square]] =
    db.run(SquareStackTable.filterById(id).result.headOption)
}
