package models.dao

import models.UserCard
import models.tables.UserCardsTable
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

/**
 * Data Access Object for fetching user_cards information from user_cards relation
 *
 * @param dbConfigProvider Database configuration provider
 * @param ec               Execution context for managing concurrency
 */
class UserCardsDao @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile] {

  import profile.api._

  private val UserCards = TableQuery[UserCardsTable]

  def all(): Future[Seq[UserCard]] = db.run(UserCards.result)

  def insert(userCard: UserCard): Future[Unit] = db.run(UserCards += userCard).map(_ => ())

  def delete(id: Int): Future[Unit] = db.run(UserCards.filter(_.id === id).delete).map(_ => ())

  def deleteAll(): Future[Unit] = db.run(UserCards.delete).map(_ => ())

  def update(userCard: UserCard): Future[Unit] = {
    val userCardToUpdate: UserCard = userCard.copy(id = userCard.id)
    db.run(UserCards.filter(_.id === userCard.id).update(userCardToUpdate)).map(_ => ())
  }

  def giveCards(): Future[Boolean] = {
    val handOutCards = sql"SELECT give_cards()".as[String]
    db.run(handOutCards.headOption).map {
      case Some(_) => true
      case None => false
    }
  }
}
