package models

/**
 * Model of a game cell.
 *
 * @param id          The id of the cell.
 * @param xCoordinate The x coordinate of the cell.
 * @param yCoordinate The y coordinate of the cell.
 * @param cardId      The id of the card in the cell.
 * @param userId      The id of the user who's on the cell or null if there's no user.
 * @param diseaseId   The id of the disease on the cell or null if there's no disease.
 * @param markerId    The id of the marker on the cell or null if there's no marker.
 */
case class GameCell(id: Int, xCoordinate: Byte, yCoordinate: Byte, cardId: Int, userId: Option[Int], diseaseId: Option[Int], markerId: Option[Int])

/**
 * Companion object of `GameCell`, full of util methods for the class including JSON conversions.
 *
 */
object GameCell {

}