package kanalony.storage.logic.queries

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.api.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class hourly_ua_prtn_entry_countryQuery extends QueryBase[hourly_ua_prtn_entry_countryQueryParams, hourly_ua_prtn_entry_countryRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): hourly_ua_prtn_entry_countryQueryParams = {
        val (partner_id,entry_id,country) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.country), params)
        hourly_ua_prtn_entry_countryQueryParams(params.start, params.end, partner_id,entry_id,country, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: hourly_ua_prtn_entry_countryQueryParams): Future[List[hourly_ua_prtn_entry_countryRow]] = {
        val rawQueryResult = hourly_ua_prtn_entry_countryTableAccessor.query(params.partner_id_list,params.entry_id_list,params.country_list,params.metric_list,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.country.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: hourly_ua_prtn_entry_countryRow): List[String] = {
        List(row.partner_id.toString,row.entry_id.toString,row.country.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: hourly_ua_prtn_entry_countryRow): Int = row.metric
    }

case class hourly_ua_prtn_entry_countryQueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], entry_id_list : List[String], country_list : List[String], metric_list : List[Int]) extends IYearlyPartitionedQueryParams