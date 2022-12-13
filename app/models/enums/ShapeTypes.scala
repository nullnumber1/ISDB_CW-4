package models.enums

object ShapeTypes extends Enumeration {
  type ShapeTypes = Value
  val SQUARE = Value("SQUARE")
  val CIRCLE = Value("CIRCLE")
  val TRIANGLE = Value("TRIANGLE")
  val STAR = Value("STAR")
}