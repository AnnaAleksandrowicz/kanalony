package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyUaPrtnBrowserClstEntryQuery extends QueryBase[HourlyUaPrtnBrowserClstEntryQueryParams, HourlyUaPrtnBrowserClstEntryRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyUaPrtnBrowserClstEntryQueryParams = {
        val (partner_id,browser) = QueryParamsValidator.extractEqualityConstraintParams[Int,Int]((Dimensions.partner,Dimensions.browser), params)
        HourlyUaPrtnBrowserClstEntryQueryParams(params.start, params.end, partner_id,browser, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: HourlyUaPrtnBrowserClstEntryQueryParams): Future[List[HourlyUaPrtnBrowserClstEntryRow]] = {
        val rawQueryResult = HourlyUaPrtnBrowserClstEntryTableAccessor.query(params.partnerIdList,params.browserList,params.months,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.browser.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.entry.toString,"value")
      }

      override protected def getResultRow(row: HourlyUaPrtnBrowserClstEntryRow): List[String] = {
        List(row.partnerId.toString,row.browser.toString,row.metric.toString,row.hour.toString,row.entryId.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyUaPrtnBrowserClstEntryRow): Int = row.metric
    }

case class HourlyUaPrtnBrowserClstEntryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], browserList : List[Int], metricList : List[Int]) extends IMonthlyPartitionedQueryParams