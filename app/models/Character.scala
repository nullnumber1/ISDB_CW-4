package models

import play.api.libs.json.{Json, JsValue, OFormat}

/**
 * Model of a game character.
 *
 * @param id Unique identifier of the character.
 * @param name Name of the character.
 * @param moving How much character can move per turn.
 * @param fight How much po character can remove from the opponent.
 * @param firingRange Range of attack.
 */
case class Character(id: Int, name: String, moving: Int, fight: Int, firingRange: Int)

/**
 * Companion object of `Character`, full of util methods for the class including JSON conversions.
 *
 */
object Character {
  implicit private val jsonFormat: OFormat[Character] = Json.format[Character]

  /**
   * Converts a JSON object into an instance
   * of `Character`. Property names in the JSON
   * object must match the field names within
   * `Character` or None will be returned.
   *
   * @param json The JSON value to convert
   * @return The converted `Character` instance or None if invalid
   */
  def fromJson(json: JsValue): Option[Character] = json.validate.asOpt

  /**
   * Converts an instance of `Character` into
   * JSON object.
   *
   * @param character An instance of `Character` to be converted
   * @return The converted JSON object entity
   */
  def toJson(character: Character): JsValue = Json.toJson(character)
}
