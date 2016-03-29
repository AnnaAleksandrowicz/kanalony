package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class MinutelyUaPrtnCountryQuery extends QueryBase[MinutelyUaPrtnCountryQueryParams, MinutelyUaPrtnCountryRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyUaPrtnCountryQueryParams = {
        val (partner_id,country) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.country), params)
        MinutelyUaPrtnCountryQueryParams(params.start, params.end, partner_id,country, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: MinutelyUaPrtnCountryQueryParams): Future[List[MinutelyUaPrtnCountryRow]] = {
        val rawQueryResult = MinutelyUaPrtnCountryTableAccessor.query(params.partnerIdList,params.countryList,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.metric.toString,Dimensions.minute.toString,"value")
      }

      override protected def getResultRow(row: MinutelyUaPrtnCountryRow): List[String] = {
        List(row.partnerId.toString,row.country.toString,row.metric.toString,row.minute.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: MinutelyUaPrtnCountryRow): Int = row.metric
    }

case class MinutelyUaPrtnCountryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], countryList : List[String], metricList : List[Int]) 