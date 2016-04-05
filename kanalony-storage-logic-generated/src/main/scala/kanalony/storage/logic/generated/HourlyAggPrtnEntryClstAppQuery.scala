package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyAggPrtnEntryClstAppQuery(accessor : IHourlyAggPrtnEntryClstAppTableAccessor) extends QueryBase[HourlyAggPrtnEntryClstAppQueryParams, HourlyAggPrtnEntryClstAppRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnEntryClstAppQueryParams = {
        val (partner_id,entry_id) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.entry), params)
        HourlyAggPrtnEntryClstAppQueryParams(params.start, params.end, partner_id,entry_id, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnEntryClstAppQueryParams): Future[List[HourlyAggPrtnEntryClstAppRow]] = {
        accessor.query(params.partnerIdList,params.entryIdList,params.metricList,params.years,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.application.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnEntryClstAppRow): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.metric.toString,row.hour.toString,row.application.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.application, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyAggPrtnEntryClstAppRow): String = row.metric
    }

case class HourlyAggPrtnEntryClstAppQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams