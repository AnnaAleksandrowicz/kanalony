package controllers

import com.kaltura.model.entities.{Metric, Metrics}
import kanalony.storage.logic.queries.model._
import kanalony.storage.logic._
import model._
import org.joda.time.format.DateTimeFormat
import org.joda.time.{LocalDateTime, DateTime}
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.mvc._
import argonaut._, Argonaut._
import scala.concurrent._
import model.Implicits._

class Application extends Controller {

  def query: Action[AnyContent] = Action.async({ implicit request => doQuery(request) })

  def doQuery(request : Request[AnyContent]) : Future[Result] = {
    try {

      val analyticsRequestOption = request.body.asJson map { input => Parse.decodeEither[AnalyticsRequest](input.toString) }

      if (analyticsRequestOption.isEmpty) {
        return wrapWithPromise(BadRequest(createErrorJsonResponse("incorrectContentType", "Ensure Content-Type is set to application/json and that the supplied JSON is valid")))
      }

      val analyticsRequest = analyticsRequestOption.get.toEither
      if (analyticsRequest.isLeft) {
        return wrapWithPromise(BadRequest(createErrorJsonResponse("invalidInput", analyticsRequest.left.get)))
      }

      val queryParams = requestToQueryParams(analyticsRequest.right.get)
      val queryExecutionResult = execute(queryParams)
      val queryResponseData =  queryExecutionResult map { data => AnalyticsResponse(data.headers, data.rows) }

      queryResponseData map {
        data => {
          val responseFormatter = ResponseFormatterFactory.get(request)
          val formattedResponse = responseFormatter.format(data)
          Ok(formattedResponse.data).as(formattedResponse.mime)
        }
      } recover {
        case e : Exception => InternalServerError(createErrorJsonResponse("generalError", e.getMessage))
      }
    }
    catch {
      case e : InvalidDimensionException => {
        return wrapWithPromise(BadRequest(createErrorJsonResponse("unsupportedDimension", e.dimensionName)))
      }
      case e: QueryNotSupportedException => {
        return wrapWithPromise(NotFound(createErrorJsonResponse("unsupportedQuery", e.getMessage)))
      }
      case e: IllegalArgumentException => {
        return wrapWithPromise(BadRequest(createErrorJsonResponse("invalidInput", e.getMessage)))
      }
      case e: Exception => {
        return wrapWithPromise(InternalServerError(createErrorJsonResponse("generalError", e.getMessage)))
      }
    }
  }

  private def createErrorJsonResponse(kind : String, data : String) = {
    ErrorResponse(kind, data).asJson.toString()
  }

  def wrapWithPromise(res : Result): Future[Result] = {
    return (Promise[Result] success res).future
  }

  def execute(queryParams: QueryParams): Future[IQueryResult] = {
    QueryExecutor.query(queryParams)
  }

  def extractValues[T, E <: Exception](values : List[String], enumConverter : String => T, exceptionCreator : String => E): List[T] = {
    var processedValue = ""
    var res = List[T]()
    try {
      values.foreach(d => {
        processedValue = d
        res = res :+ enumConverter(d)
      })
      res
    }
    catch {
      case e : Exception => throw exceptionCreator(processedValue)
    }
  }

  def extractMetrics(metrics : List[String]): List[Metric] = {
    extractValues(metrics, Metrics.get(_), metric => new InvalidMetricsException(s"Metric $metric not supported"))
  }

  def extractDimension(dimension : String): Dimensions.Value = {
    extractValues(List(dimension), Dimensions.withName(_), s => new InvalidDimensionException(s)).head
  }

  def extractDimensions(dimensions : List[String]): List[Dimensions.Value] = {
    extractValues(dimensions, Dimensions.withName(_), s => new InvalidDimensionException(s))
  }

  def extractTime(time : String) : LocalDateTime = {
    val formatter = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm")
    formatter.parseLocalDateTime(time)
  }

  def createConstraint(dimension: Dimensions.Value, values: List[String]) : IDimensionConstraint = {
    try {
      dimension match {
        case Dimensions.partner | Dimensions.operatingSystem | Dimensions.browser | Dimensions.device  => {
          new DimensionEqualityConstraint[Int](values.toSet.map { (v: String) => v.toInt })
        }
        case _ => new DimensionEqualityConstraint(values.toSet)
      }
    }
    catch {
      case e : NumberFormatException => { throw new IllegalArgumentException(s"Dimension $dimension supplied invalid values")}
    }
  }

  def requestToQueryParams(req : AnalyticsRequest) : QueryParams = {

    val dimensionsInResult = extractDimensions(req.dimensions)
    val metricsInResult = extractMetrics(req.metrics)

    if (metricsInResult.isEmpty){
      throw new MetricNotSuppliedException
    }

    val constrainedDimensionDefinitions = req.filters.map {
      f => {
        val dimension = extractDimension(f.dimension)
        val shouldAppearInResult = dimensionsInResult contains dimension
        val dimensionConstraint = createConstraint(dimension, f.values)
        QueryDimensionDefinition(dimension, dimensionConstraint, shouldAppearInResult)
      }
    }

    val unconstrainedDimensionDefinitions = dimensionsInResult.filter(d => !(constrainedDimensionDefinitions.map(_.dimension) contains d)) map {
      dimension => QueryDimensionDefinition(dimension , new DimensionUnconstrained, true)
    }

    QueryParams(constrainedDimensionDefinitions ::: unconstrainedDimensionDefinitions, metricsInResult, extractTime(req.from), extractTime(req.to), req.utcOffset)
  }
}