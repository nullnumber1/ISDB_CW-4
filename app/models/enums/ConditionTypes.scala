package models.enums

object ConditionTypes extends Enumeration {
  type ConditionTypes = Value
  val COMPLETE_PROXIMITY = Value("COMPLETE_PROXIMITY")
  val CAFE_PROXIMITY = Value("CAFE_PROXIMITY")
  val ATTRACTION_PROXIMITY = Value("ATTRACTION_PROXIMITY")
  val SLIDE_PROXIMITY = Value("SLIDE_PROXIMITY")
  val SQUARE_CAFE_PROXIMITY = Value("SQUARE_CAFE_PROXIMITY")
  val DOUBLE_SQUARE_PROXIMITY = Value("DOUBLE_SQUARE_PROXIMITY")
  val DOUBLE_CIRCLE_PROXIMITY = Value("DOUBLE_CIRCLE_PROXIMITY")
  val DOUBLE_STAR_PROXIMITY = Value("DOUBLE_STAR_PROXIMITY")
  val STAR_SLIDE_PROXIMITY = Value("STAR_SLIDE_PROXIMITY")
  val CIRCLE_ATTRACTION_PROXIMITY = Value("CIRCLE_ATTRACTION_PROXIMITY")
}
