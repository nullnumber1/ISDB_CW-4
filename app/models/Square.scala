package models

import play.api.libs.json.{JsValue, Json, OFormat}

/**
 * The square stack model.
 *
 * @param id        The stack id
 * @param name      The stack name
 * @param po_amount The amount of points that card gives
 * @param shape     The shape of the card
 * @param obj       The object located the card
 * @param action    The action that the card requires the user to do
 * @param condition The condition that the card requires the user to meet
 */
case class Square(id: Int, name: String, poAmount: Byte, shapeId: Int, objectId: Int, actionId: Option[Int], conditionId: Option[Int])

object Square {
  implicit private val jsonFormat: OFormat[Square] = Json.format[Square]

  def fromJson(json: JsValue): Option[Square] = json.validate.asOpt

  def toJson(square: Square): JsValue = Json.toJson(square)

  def toJson(squares: Seq[Square]): JsValue = Json.toJson(squares)
}