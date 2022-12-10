package models

/**
 * Model of a user effect.
 *
 * @param id         Unique identifier for the effect
 * @param userId     Id of user effect applies to
 * @param responseId Id of response effect
 */
case class Effect(id: Int, userId: Int, responseId: Int)

object Effect {

}
