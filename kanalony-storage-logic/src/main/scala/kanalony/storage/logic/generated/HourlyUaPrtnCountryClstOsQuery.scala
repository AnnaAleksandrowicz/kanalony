package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyUaPrtnCountryClstOsQuery extends QueryBase[HourlyUaPrtnCountryClstOsQueryParams, HourlyUaPrtnCountryClstOsRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyUaPrtnCountryClstOsQueryParams = {
        val (partner_id,country) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.country), params)
        HourlyUaPrtnCountryClstOsQueryParams(params.start, params.end, partner_id,country, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: HourlyUaPrtnCountryClstOsQueryParams): Future[List[HourlyUaPrtnCountryClstOsRow]] = {
        val rawQueryResult = HourlyUaPrtnCountryClstOsTableAccessor.query(params.partnerIdList,params.countryList,params.years,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.operatingSystem.toString,"value")
      }

      override protected def getResultRow(row: HourlyUaPrtnCountryClstOsRow): List[String] = {
        List(row.partnerId.toString,row.country.toString,row.metric.toString,row.hour.toString,row.operatingSystem.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyUaPrtnCountryClstOsRow): Int = row.metric
    }

case class HourlyUaPrtnCountryClstOsQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], countryList : List[String], metricList : List[Int]) extends IYearlyPartitionedQueryParams