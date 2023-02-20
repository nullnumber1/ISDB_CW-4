package myfilters

import akka.stream.Materializer
import play.api.mvc.{Filter, RequestHeader, Result}

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class AddAccessControlAllowOriginHeaderFilter @Inject()(implicit val executionContext: ExecutionContext, val mat: Materializer) extends Filter {
  def apply(nextFilter: RequestHeader => Future[Result])(requestHeader: RequestHeader): Future[Result] = {
    nextFilter(requestHeader).map { result =>
      result.withHeaders(
        "Access-Control-Allow-Origin" -> "*",
        "Access-Control-Allow-Methods" -> "GET, POST, PUT, DELETE, OPTIONS",
        "Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Authorization, X-Auth",
        "Access-Control-Allow-Credentials" -> "true"
      )
    }
  }
}
