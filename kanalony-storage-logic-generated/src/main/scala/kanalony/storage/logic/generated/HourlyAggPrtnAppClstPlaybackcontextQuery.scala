package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.{DateTimeZone, DateTime}
    import scala.concurrent.Future

    class HourlyAggPrtnAppClstPlaybackcontextQuery(accessor : IHourlyAggPrtnAppClstPlaybackcontextTableAccessor) extends QueryBase[HourlyAggPrtnAppClstPlaybackcontextQueryParams, HourlyAggPrtnAppClstPlaybackcontextRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnAppClstPlaybackcontextQueryParams = {
        val (partner_id,application) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.application), params)
        HourlyAggPrtnAppClstPlaybackcontextQueryParams(params.startUtc, params.endUtc, partner_id,application, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnAppClstPlaybackcontextQueryParams): Future[List[HourlyAggPrtnAppClstPlaybackcontextRow]] = {
        accessor.query(params.partnerIdList,params.applicationList,params.metricList,params.years,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.application.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.playbackContext.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnAppClstPlaybackcontextRow): List[String] = {
        List(row.partnerId.toString,row.application.toString,row.metric.toString,row.hour.toString,row.playbackContext.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.application, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.playbackContext, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyAggPrtnAppClstPlaybackcontextRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : HourlyAggPrtnAppClstPlaybackcontextRow, timezoneOffsetFromUtc : Int) : HourlyAggPrtnAppClstPlaybackcontextRow = {
        HourlyAggPrtnAppClstPlaybackcontextRow(row.partnerId, row.application, row.metric, row.year, row.hour.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.playbackContext, row.value)
      }

    }

case class HourlyAggPrtnAppClstPlaybackcontextQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], applicationList : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams