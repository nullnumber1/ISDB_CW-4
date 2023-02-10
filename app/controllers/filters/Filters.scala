package controllers.filters

import akka.actor.TypedActor.dispatcher
import akka.stream.Materializer
import play.api.Logger
import play.api.http.HttpFilters
import play.api.mvc.{Filter, RequestHeader, Result}
import play.filters.cors.CORSFilter

import javax.inject.Inject
import scala.concurrent.Future

class Filters @Inject() (corsFilter: CORSFilter, log: LoggingFilter) extends HttpFilters {
  def filters = {
    // CORS filter does not work
    //Seq(corsFilter, log)
    Seq(log)
  }
}

class LoggingFilter extends Filter {

  def apply(nextFilter: RequestHeader => Future[Result])(requestHeader: RequestHeader): Future[Result] = {

    val startTime = System.currentTimeMillis

    nextFilter(requestHeader).map { result =>

      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime

      result.withHeaders(
        "Request-Time" -> requestTime.toString,
        "Access-Control-Allow-Origin" -> "*"   // Added this header
      )
    }
  }

  override implicit def mat: Materializer = ???
}