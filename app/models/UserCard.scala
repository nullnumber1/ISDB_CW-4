package models

/**
 * Model of a user card.
 *
 * @param id     user card id
 * @param userId user id
 * @param cardId card id
 */
case class UserCard(id: Int, userId: Int, cardId: Int)

/**
 * Companion object of `UserCard`, full of util methods for the class including JSON conversions.
 *
 */
object UserCard {

}