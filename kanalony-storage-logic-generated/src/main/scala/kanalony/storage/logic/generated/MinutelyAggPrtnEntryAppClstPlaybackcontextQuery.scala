package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class MinutelyAggPrtnEntryAppClstPlaybackcontextQuery extends QueryBase[MinutelyAggPrtnEntryAppClstPlaybackcontextQueryParams, MinutelyAggPrtnEntryAppClstPlaybackcontextRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnEntryAppClstPlaybackcontextQueryParams = {
        val (partner_id,entry_id,application) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.application), params)
        MinutelyAggPrtnEntryAppClstPlaybackcontextQueryParams(params.start, params.end, partner_id,entry_id,application, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnEntryAppClstPlaybackcontextQueryParams): Future[List[MinutelyAggPrtnEntryAppClstPlaybackcontextRow]] = {
        val rawQueryResult = MinutelyAggPrtnEntryAppClstPlaybackcontextTableAccessor.query(params.partnerIdList,params.entryIdList,params.applicationList,params.metricList,params.days,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.application.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.playbackContext.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnEntryAppClstPlaybackcontextRow): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.application.toString,row.metric.toString,row.minute.toString,row.playbackContext.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.application, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.playbackContext, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: MinutelyAggPrtnEntryAppClstPlaybackcontextRow): String = row.metric
    }

case class MinutelyAggPrtnEntryAppClstPlaybackcontextQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], applicationList : List[String], metricList : List[String]) extends IDailyPartitionedQueryParams