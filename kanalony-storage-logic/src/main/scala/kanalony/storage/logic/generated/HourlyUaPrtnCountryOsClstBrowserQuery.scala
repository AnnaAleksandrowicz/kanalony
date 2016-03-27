package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyUaPrtnCountryOsClstBrowserQuery extends QueryBase[HourlyUaPrtnCountryOsClstBrowserQueryParams, HourlyUaPrtnCountryOsClstBrowserRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyUaPrtnCountryOsClstBrowserQueryParams = {
        val (partner_id,country,operating_system) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,Int]((Dimensions.partner,Dimensions.country,Dimensions.operatingSystem), params)
        HourlyUaPrtnCountryOsClstBrowserQueryParams(params.start, params.end, partner_id,country,operating_system, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: HourlyUaPrtnCountryOsClstBrowserQueryParams): Future[List[HourlyUaPrtnCountryOsClstBrowserRow]] = {
        val rawQueryResult = HourlyUaPrtnCountryOsClstBrowserTableAccessor.query(params.partnerIdList,params.countryList,params.operatingSystemList,params.metricList,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.operatingSystem.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.browser.toString,"value")
      }

      override protected def getResultRow(row: HourlyUaPrtnCountryOsClstBrowserRow): List[String] = {
        List(row.partnerId.toString,row.country.toString,row.operatingSystem.toString,row.metric.toString,row.hour.toString,row.browser.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: HourlyUaPrtnCountryOsClstBrowserRow): Int = row.metric
    }

case class HourlyUaPrtnCountryOsClstBrowserQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], countryList : List[String], operatingSystemList : List[Int], metricList : List[Int]) extends IYearlyPartitionedQueryParams