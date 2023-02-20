package models.dao

import models.tables.{GameFieldTable, SquareStackTable}
import models.{GameCell, Square}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class SquareStackDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  //get all cards
  def getAll: Future[Seq[Square]] = db.run(SquareStackTable.result)

  /**
   * Finds `SquareStack` entity using the stack id. Returns None if not found.
   *
   * @param id Stack id
   * @return `SquareStack` entity from database
   */
  def findById(id: Int): Future[Option[Square]] =
    db.run(SquareStackTable.filterById(id).result.headOption)

  def buildSquare(name: String, coordinateX: Int, coordinateY: Int): Future[Boolean] = {
    db.run(SquareStackTable.findByName(name).result.headOption).flatMap {
      case Some(square) =>
        val gameFieldSquare = GameCell(
          id = 1,
          xCoordinate = coordinateX.toByte,
          yCoordinate = coordinateY.toByte,
          cardId = square.id,
          diseaseId = None,
          userId = None,
          markerId = None
        )
        db.run(GameFieldTable returning GameFieldTable += gameFieldSquare).map(_ => true)
      case None =>
        Future.successful(false)
    }
  }
}
