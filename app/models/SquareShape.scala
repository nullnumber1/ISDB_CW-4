package models

import models.enums.ShapeTypes.ShapeTypes

/**
 * A SquareShape is a shape located on square.
 *
 * @param id    The id of the shape.
 * @param sType The type of the shape.
 */
case class SquareShape(id: Int, sType: ShapeTypes)

/**
 * Companion object of `SquareShape`, full of util methods for the class including JSON conversions.
 */
object SquareShape {

}