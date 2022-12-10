package models.enums

/**
 * Enum defining types of organism response.
 *
 */
object ResponseTypes extends Enumeration {
  type ResponseTypes = Value
  val DISEASE = Value("DISEASE")
  val ACTION = Value("ACTION")
  val EFFECT = Value("EFFECT")
  val INFARCTION = Value("INFARCT")
}