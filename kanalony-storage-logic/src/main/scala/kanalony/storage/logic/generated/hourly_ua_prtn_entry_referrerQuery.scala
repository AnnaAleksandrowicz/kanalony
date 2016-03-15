package kanalony.storage.logic.queries

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class hourly_ua_prtn_entry_referrerQuery extends QueryBase[hourly_ua_prtn_entry_referrerQueryParams, hourly_ua_prtn_entry_referrerRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): hourly_ua_prtn_entry_referrerQueryParams = {
        val (partner_id,entry_id,referrer) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.referrer), params)
        hourly_ua_prtn_entry_referrerQueryParams(params.start, params.end, partner_id,entry_id,referrer, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: hourly_ua_prtn_entry_referrerQueryParams): Future[List[hourly_ua_prtn_entry_referrerRow]] = {
        val rawQueryResult = hourly_ua_prtn_entry_referrerTableAccessor.query(params.partner_id_list,params.entry_id_list,params.referrer_list,params.metric_list,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.referrer.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: hourly_ua_prtn_entry_referrerRow): List[String] = {
        List(row.partner_id.toString,row.entry_id.toString,row.referrer.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.referrer, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: hourly_ua_prtn_entry_referrerRow): Int = row.metric
    }

case class hourly_ua_prtn_entry_referrerQueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], entry_id_list : List[String], referrer_list : List[String], metric_list : List[Int]) extends IYearlyPartitionedQueryParams