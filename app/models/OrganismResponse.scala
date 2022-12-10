package models

import models.enums.ResponseTypes.ResponseTypes

/**
 * Model of a record in the organisms relation.
 *
 * @param id    Unique identifier for the organism
 * @param rType The type of the response
 * @param name  The name of the response
 */
case class OrganismResponse(id: Int, rType: ResponseTypes, name: String)

/**
 * Companion object of `OrganismResponse`, full of util methods for the class including JSON conversions.
 *
 */
object OrganismResponse {

}
