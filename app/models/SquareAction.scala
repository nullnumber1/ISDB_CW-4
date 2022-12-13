package models

import models.enums.ActionTypes.ActionTypes

/**
 * Represents a Square action.
 *
 * @param id    Unique identifier for the action
 * @param aType The type of the action
 */
case class SquareAction(id: Int, aType: ActionTypes)

/**
 * Companion object of `SquareAction`, full of util methods for the class including JSON conversions.
 */
object SquareAction {

}