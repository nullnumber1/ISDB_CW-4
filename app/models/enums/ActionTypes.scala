package models.enums

object ActionTypes extends Enumeration {
  type ActionTypes = Value
  val EXIT = Value("EXIT")
  val CONTROL_MARKER_ATTRACTION = Value("CONTROL_MARKER_ATTRACTION")
  val CONTROL_MARKER_CAFE = Value("CONTROL_MARKER_CAFE")
  val CONTROL_MARKER_SLIDE = Value("CONTROL_MARKER_SLIDE")
  val CONTROL_MARKER_SQUARE = Value("CONTROL_MARKER_SQUARE")
  val CONTROL_MARKER_CIRCLE = Value("CONTROL_MARKER_CIRCLE")
  val CONTROL_MARKER_STAR = Value("CONTROL_MARKER_STAR")
  val CONTROL_MARKER_MINUS = Value("CONTROL_MARKER_MINUS")
  val TAKE_CARD = Value("TAKE_CARD")
  val NEIGHBOUR_BONUS_STAR = Value("NEIGHBOUR_BONUS_STAR")
  val NEIGHBOUR_BONUS_SQUARE = Value("NEIGHBOUR_BONUS_SQUARE")
  val NEIGHBOUR_BONUS_CIRCLE = Value("NEIGHBOUR_BONUS_CIRCLE")
  val TAKE_ORGANISM_RESPONSE = Value("TAKE_ORGANISM_RESPONSE")
  val CAFE_BONUS = Value("CAFE_BONUS")
}

