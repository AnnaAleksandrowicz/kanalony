package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyAggPrtnAppClstEntryQuery(accessor : IHourlyAggPrtnAppClstEntryTableAccessor) extends QueryBase[HourlyAggPrtnAppClstEntryQueryParams, HourlyAggPrtnAppClstEntryRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnAppClstEntryQueryParams = {
        val (partner_id,application) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.application), params)
        HourlyAggPrtnAppClstEntryQueryParams(params.startUtc, params.endUtc, partner_id,application, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnAppClstEntryQueryParams): Future[List[HourlyAggPrtnAppClstEntryRow]] = {
        accessor.query(params.partnerIdList,params.applicationList,params.months,params.metricList,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.application.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.entry.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnAppClstEntryRow): List[String] = {
        List(row.partnerId.toString,row.application.toString,row.metric.toString,row.hour.toString,row.entryId.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.application, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyAggPrtnAppClstEntryRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : HourlyAggPrtnAppClstEntryRow, timezoneOffsetFromUtc : Int) : HourlyAggPrtnAppClstEntryRow = {
        HourlyAggPrtnAppClstEntryRow(row.partnerId, row.application, row.month, row.metric, row.hour.plusHours(timezoneOffsetFromUtc), row.entryId, row.value)
      }

    }

case class HourlyAggPrtnAppClstEntryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], applicationList : List[String], metricList : List[String]) extends IMonthlyPartitionedQueryParams