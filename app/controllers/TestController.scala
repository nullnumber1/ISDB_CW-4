package controllers

import models.Square
import models.dao.{SquareStackDao, UserCardsDao}
import play.api.Logging
import play.api.mvc._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class TestController @Inject()(squareStackDao: SquareStackDao, userCardsDao: UserCardsDao, components: ControllerComponents)(implicit ex: ExecutionContext) extends AbstractController(components) with Logging {
  def getAll: Action[AnyContent] = Action.async {
    squareStackDao.getAll.map { stacks =>
      Ok(Square.toJson(stacks))
    }
  }

  def getCard(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    squareStackDao.findById(id).map {
      case Some(card) => Ok(Square.toJson(card))
      case None => NotFound
    }
  }

  def handOutCards: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    userCardsDao.giveCards().map {
      case true => Ok
      case false => InternalServerError("Something went wrong")
    }
  }

  def clearCards: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    userCardsDao.deleteAll().map(_ => Ok)
  }
}
