package models

import models.enums.ObjectTypes.ObjectTypes

/**
 * A SquareObject is an object located on square.
 *
 * @param id    The id of the object.
 * @param oType The type of the object.
 */
case class SquareObject(id: Int, oType: ObjectTypes)

/**
 * Companion object of `SquareObject`, full of util methods for the class including JSON conversions.
 */
object SquareObject {

}