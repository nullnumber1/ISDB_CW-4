package controllers

import play.api.mvc._

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext

@Singleton
class OptionsController @Inject()(components: ControllerComponents)(implicit ex: ExecutionContext) extends AbstractController(components) {
  private def headers = List(
    "Access-Control-Allow-Origin" -> "*",
    "Access-Control-Allow-Methods" -> "GET, POST, OPTIONS, DELETE, PUT",
    "Access-Control-Max-Age" -> "3600",
    "Access-Control-Allow-Headers" -> "Origin, Content-Type, Accept, Authorization",
    "Access-Control-Allow-Credentials" -> "true"
  )

  def rootOptions = options("/")
  def options(url: String) = Action {
    request => {
      NoContent.withHeaders(headers: _*)
    }
  }
}
