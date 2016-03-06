package kanalony.storage.logic.queries

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.api.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class hourly_ua_prtn_country_cityQuery extends QueryBase[hourly_ua_prtn_country_cityQueryParams, hourly_ua_prtn_country_cityRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): hourly_ua_prtn_country_cityQueryParams = {
        val (partner_id,country,city) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.country,Dimensions.city), params)
        hourly_ua_prtn_country_cityQueryParams(params.start, params.end, partner_id,country,city, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: hourly_ua_prtn_country_cityQueryParams): Future[List[hourly_ua_prtn_country_cityRow]] = {
        val rawQueryResult = hourly_ua_prtn_country_cityTableAccessor.query(params.partner_id_list,params.country_list,params.city_list,params.metric_list,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.city.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: hourly_ua_prtn_country_cityRow): List[String] = {
        List(row.partner_id.toString,row.country.toString,row.city.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.city, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: hourly_ua_prtn_country_cityRow): Int = row.metric
    }

case class hourly_ua_prtn_country_cityQueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], country_list : List[String], city_list : List[String], metric_list : List[Int]) extends IYearlyPartitionedQueryParams