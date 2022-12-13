package models

/**
 * model of a control marker.
 *
 * @param id     The id of the control marker
 * @param userId The id of the user who marker belongs to
 * @param amount Amount of control markers¬
 */
case class ControlMarker(id: Int, userId: Int, amount: Byte)

/**
 * Companion object of `ControlMarker`, full of util methods for the class including JSON conversions.
 *
 */
object ControlMarker {

}