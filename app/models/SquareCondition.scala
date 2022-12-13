package models

import models.enums.ConditionTypes.ConditionTypes

/**
 * Class representing a condition that a square must satisfy.
 *
 * @param id Unique identifier for the condition.
 * @param aType The type of the condition.
 */
case class SquareCondition(id: Int, aType: ConditionTypes)

/**
 * Companion object of `SquareCondition`, full of util methods for the class including JSON conversions.
 */
object SquareCondition {

}