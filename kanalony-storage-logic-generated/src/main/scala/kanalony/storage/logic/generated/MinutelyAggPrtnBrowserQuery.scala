package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class MinutelyAggPrtnBrowserQuery extends QueryBase[MinutelyAggPrtnBrowserQueryParams, MinutelyAggPrtnBrowserRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnBrowserQueryParams = {
        val (partner_id,browser) = QueryParamsValidator.extractEqualityConstraintParams[Int,Int]((Dimensions.partner,Dimensions.browser), params)
        MinutelyAggPrtnBrowserQueryParams(params.start, params.end, partner_id,browser, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnBrowserQueryParams): Future[List[MinutelyAggPrtnBrowserRow]] = {
        val rawQueryResult = MinutelyAggPrtnBrowserTableAccessor.query(params.partnerIdList,params.browserList,params.metricList,params.days,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.browser.toString,Dimensions.metric.toString,Dimensions.minute.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnBrowserRow): List[String] = {
        List(row.partnerId.toString,row.browser.toString,row.metric.toString,row.minute.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: MinutelyAggPrtnBrowserRow): String = row.metric
    }

case class MinutelyAggPrtnBrowserQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], browserList : List[Int], metricList : List[String]) extends IDailyPartitionedQueryParams