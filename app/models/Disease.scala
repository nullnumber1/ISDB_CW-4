package models

/**
 * Model of a disease.
 *
 * @param id           Unique identifier for the disease
 * @param name         The name of the disease
 * @param poReward     The reward for the player if the disease is cured
 * @param squareReward The reward for the square if the disease is cured
 * @param xCoordinate  The x coordinate of the disease
 * @param yCoordinate  The y coordinate of the disease
 */
case class Disease(id: Int, name: String, poReward: Byte, squareReward: Option[Byte], xCoordinate: Option[Byte], yCoordinate: Option[Byte])

/**
 * Companion object of `Disease`, full of util methods for the class including JSON conversions.
 *
 */
object Disease {

}