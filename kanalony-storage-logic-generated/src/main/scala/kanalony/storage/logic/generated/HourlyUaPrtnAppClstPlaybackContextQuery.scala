package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyUaPrtnAppClstPlaybackContextQuery extends QueryBase[HourlyUaPrtnAppClstPlaybackContextQueryParams, HourlyUaPrtnAppClstPlaybackContextRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyUaPrtnAppClstPlaybackContextQueryParams = {
        val (partner_id,application) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.application), params)
        HourlyUaPrtnAppClstPlaybackContextQueryParams(params.start, params.end, partner_id,application, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: HourlyUaPrtnAppClstPlaybackContextQueryParams): Future[List[HourlyUaPrtnAppClstPlaybackContextRow]] = {
        val rawQueryResult = HourlyUaPrtnAppClstPlaybackContextTableAccessor.query(params.partnerIdList,params.applicationList,params.metricList,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.application.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.playbackContext.toString,"value")
      }

      override protected def getResultRow(row: HourlyUaPrtnAppClstPlaybackContextRow): List[String] = {
        List(row.partnerId.toString,row.application.toString,row.metric.toString,row.hour.toString,row.playbackContext.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.application, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.playbackContext, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyUaPrtnAppClstPlaybackContextRow): Int = row.metric
    }

case class HourlyUaPrtnAppClstPlaybackContextQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], applicationList : List[String], metricList : List[Int]) extends IYearlyPartitionedQueryParams