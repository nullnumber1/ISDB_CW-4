package models.dao

import models.GameCell
import models.tables.GameFieldTable
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

/**
 * Data Access Object for fetching game field information from game_field relation
 *
 * @param dbConfigProvider Database configuration provider
 * @param ec               Execution context for managing concurrency
 */
class GameFieldDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val GameCells = TableQuery[GameFieldTable]

  def all(): Future[Seq[GameCell]] = db.run(GameCells.result)

  def insert(gameCell: GameCell): Future[Unit] = db.run(GameCells += gameCell).map(_ => ())

  def delete(id: Int): Future[Unit] = db.run(GameCells.filter(_.id === id).delete).map(_ => ())

  def update(gameCell: GameCell): Future[Unit] = {
    val gameCellToUpdate: GameCell = gameCell.copy(id = gameCell.id)
    db.run(GameCells.filter(_.id === gameCell.id).update(gameCellToUpdate)).map(_ => ())
  }
}
