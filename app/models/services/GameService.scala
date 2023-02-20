package models.services

import models.dao.SquareStackDao

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class GameService @Inject()(squareStackDao: SquareStackDao)(implicit ec: ExecutionContext) {
  def buildSquare(name: String, coordinateX: Int, coordinateY: Int): Future[Boolean] = {
    squareStackDao.buildSquare(name, coordinateX, coordinateY)
  }

  def performAction(action: String, name: Option[String], coordinateX: Option[Int], coordinateY: Option[Int]): Future[Boolean] = {
    action match {
      case "build" => squareStackDao.buildSquare(name.get, coordinateX.get, coordinateY.get)
      case _ => Future.successful(false)
    }
  }
}
