package controllers

import models.Square
import models.dao.SquareStackDao
import play.api.Logging
import play.api.mvc._

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class TestController @Inject()(dao: SquareStackDao, components: ControllerComponents)(implicit ex: ExecutionContext) extends AbstractController(components) with Logging {
  def getAll: Action[AnyContent] = Action.async {
    dao.getAll.map { stacks =>
      Ok(Square.toJson(stacks))
    }
  }

  def getCard(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    dao.findById(id).map {
      case Some(card) => Ok(Square.toJson(card))
      case None => NotFound
    }
  }
}
