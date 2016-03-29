package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class TensecsUaPrtnCountryClstOsBrowserQuery extends QueryBase[TensecsUaPrtnCountryClstOsBrowserQueryParams, TensecsUaPrtnCountryClstOsBrowserRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): TensecsUaPrtnCountryClstOsBrowserQueryParams = {
        val (partner_id,country) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.country), params)
        TensecsUaPrtnCountryClstOsBrowserQueryParams(params.start, params.end, partner_id,country, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: TensecsUaPrtnCountryClstOsBrowserQueryParams): Future[List[TensecsUaPrtnCountryClstOsBrowserRow]] = {
        val rawQueryResult = TensecsUaPrtnCountryClstOsBrowserTableAccessor.query(params.partnerIdList,params.countryList,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.metric.toString,Dimensions.tenSeconds.toString,Dimensions.operatingSystem.toString,Dimensions.browser.toString,"value")
      }

      override protected def getResultRow(row: TensecsUaPrtnCountryClstOsBrowserRow): List[String] = {
        List(row.partnerId.toString,row.country.toString,row.metric.toString,row.tensecs.toString,row.operatingSystem.toString,row.browser.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.tenSeconds, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: TensecsUaPrtnCountryClstOsBrowserRow): Int = row.metric
    }

case class TensecsUaPrtnCountryClstOsBrowserQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], countryList : List[String], metricList : List[Int]) 