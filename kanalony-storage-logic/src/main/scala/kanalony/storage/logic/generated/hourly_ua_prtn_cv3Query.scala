package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class hourly_ua_prtn_cv3Query extends QueryBase[hourly_ua_prtn_cv3QueryParams, hourly_ua_prtn_cv3Row] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): hourly_ua_prtn_cv3QueryParams = {
        val (partner_id,custom_var3) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.cf3), params)
        hourly_ua_prtn_cv3QueryParams(params.start, params.end, partner_id,custom_var3, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: hourly_ua_prtn_cv3QueryParams): Future[List[hourly_ua_prtn_cv3Row]] = {
        val rawQueryResult = hourly_ua_prtn_cv3TableAccessor.query(params.partner_id_list,params.custom_var3_list,params.metric_list,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.cf3.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: hourly_ua_prtn_cv3Row): List[String] = {
        List(row.partner_id.toString,row.custom_var3.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf3, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: hourly_ua_prtn_cv3Row): Int = row.metric
    }

case class hourly_ua_prtn_cv3QueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], custom_var3_list : List[String], metric_list : List[Int]) extends IYearlyPartitionedQueryParams