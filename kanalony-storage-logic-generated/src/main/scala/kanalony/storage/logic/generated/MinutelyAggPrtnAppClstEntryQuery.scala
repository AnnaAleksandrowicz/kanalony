package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.{DateTimeZone, DateTime}
    import scala.concurrent.Future

    class MinutelyAggPrtnAppClstEntryQuery(accessor : IMinutelyAggPrtnAppClstEntryTableAccessor) extends QueryBase[MinutelyAggPrtnAppClstEntryQueryParams, MinutelyAggPrtnAppClstEntryRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnAppClstEntryQueryParams = {
        val (partner_id,application) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.application), params)
        MinutelyAggPrtnAppClstEntryQueryParams(params.startUtc, params.endUtc, partner_id,application, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnAppClstEntryQueryParams): Future[List[MinutelyAggPrtnAppClstEntryRow]] = {
        accessor.query(params.partnerIdList,params.applicationList,params.days,params.metricList,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.application.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.entry.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnAppClstEntryRow): List[String] = {
        List(row.partnerId.toString,row.application.toString,row.metric.toString,row.minute.toString,row.entryId.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.application, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: MinutelyAggPrtnAppClstEntryRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : MinutelyAggPrtnAppClstEntryRow, timezoneOffsetFromUtc : Int) : MinutelyAggPrtnAppClstEntryRow = {
        MinutelyAggPrtnAppClstEntryRow(row.partnerId, row.application, row.day, row.metric, row.minute.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.entryId, row.value)
      }

    }

case class MinutelyAggPrtnAppClstEntryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], applicationList : List[String], metricList : List[String]) extends IDailyPartitionedQueryParams