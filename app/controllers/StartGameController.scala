package controllers

import models.dao.{GameFieldDao, SquareStackDao, UserCardsDao}
import models.services.GameService
import models.{GameCell, Square}
import play.api.Logging
import play.api.mvc._

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext

@Singleton
class StartGameController @Inject()(
                                     squareStackDao: SquareStackDao,
                                     userCardsDao: UserCardsDao,
                                     gameFieldDao: GameFieldDao,
                                     gameService: GameService,
                                     components: ControllerComponents

                                   )(implicit ex: ExecutionContext) extends AbstractController(components) with Logging {
  def getAllCardsFromField: Action[AnyContent] = Action.async {
    gameFieldDao.getAll.map { stacks =>
      Ok(GameCell.toJson(stacks))
    }
  }

  def getCard(id: Int): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    squareStackDao.findById(id).map {
      case Some(card) => Ok(Square.toJson(card))
      case None => NotFound
    }
  }

  def clearCards: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    userCardsDao.deleteAll().map(_ => Ok)
  }

  def initGame: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    gameService.buildSquare("Вход", 0, 0)
    userCardsDao.giveCards().map {
      case true => Ok
      case false => InternalServerError("Something went wrong")
    }
  }

  def performAction: Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    val action = request.body.asJson.get("action").as[String]
    val name: Option[String] = request.body.asJson.get("name").asOpt[String]
    val coordinateX: Option[Int] = request.body.asJson.get("coordinateX").asOpt[Int]
    val coordinateY: Option[Int] = request.body.asJson.get("coordinateY").asOpt[Int]
    printf(action + "   " + name + "   " + coordinateX + "   " + coordinateY)
    gameService.performAction(action, name, coordinateX, coordinateY) map {
      case true => Ok("Action performed")
      case false => InternalServerError("Something went wrong")
    }
  }
}
