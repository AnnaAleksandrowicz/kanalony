package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class hourly_ua_prtn_country_city_clst_entryQuery extends QueryBase[hourly_ua_prtn_country_city_clst_entryQueryParams, hourly_ua_prtn_country_city_clst_entryRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): hourly_ua_prtn_country_city_clst_entryQueryParams = {
        val (partner_id,country,city) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.country,Dimensions.city), params)
        hourly_ua_prtn_country_city_clst_entryQueryParams(params.start, params.end, partner_id,country,city, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: hourly_ua_prtn_country_city_clst_entryQueryParams): Future[List[hourly_ua_prtn_country_city_clst_entryRow]] = {
        val rawQueryResult = hourly_ua_prtn_country_city_clst_entryTableAccessor.query(params.partner_id_list,params.country_list,params.city_list,params.years,params.metric_list,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.city.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.entry.toString,"value")
      }

      override protected def getResultRow(row: hourly_ua_prtn_country_city_clst_entryRow): List[String] = {
        List(row.partner_id.toString,row.country.toString,row.city.toString,row.metric.toString,row.hour.toString,row.entry_id.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.city, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: hourly_ua_prtn_country_city_clst_entryRow): Int = row.metric
    }

case class hourly_ua_prtn_country_city_clst_entryQueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], country_list : List[String], city_list : List[String], metric_list : List[Int]) extends IYearlyPartitionedQueryParams