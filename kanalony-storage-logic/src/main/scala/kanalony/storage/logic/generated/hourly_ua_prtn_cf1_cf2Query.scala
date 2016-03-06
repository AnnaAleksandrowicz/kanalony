package kanalony.storage.logic.queries

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.api.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class hourly_ua_prtn_cf1_cf2Query extends QueryBase[hourly_ua_prtn_cf1_cf2QueryParams, hourly_ua_prtn_cf1_cf2Row] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): hourly_ua_prtn_cf1_cf2QueryParams = {
        val (partner_id,cf1,cf2) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.cf1,Dimensions.cf2), params)
        hourly_ua_prtn_cf1_cf2QueryParams(params.start, params.end, partner_id,cf1,cf2, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: hourly_ua_prtn_cf1_cf2QueryParams): Future[List[hourly_ua_prtn_cf1_cf2Row]] = {
        val rawQueryResult = hourly_ua_prtn_cf1_cf2TableAccessor.query(params.partner_id_list,params.cf1_list,params.cf2_list,params.metric_list,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.cf1.toString,Dimensions.cf2.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: hourly_ua_prtn_cf1_cf2Row): List[String] = {
        List(row.partner_id.toString,row.cf1.toString,row.cf2.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf1, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf2, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: hourly_ua_prtn_cf1_cf2Row): Int = row.metric
    }

case class hourly_ua_prtn_cf1_cf2QueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], cf1_list : List[String], cf2_list : List[String], metric_list : List[Int]) extends IYearlyPartitionedQueryParams