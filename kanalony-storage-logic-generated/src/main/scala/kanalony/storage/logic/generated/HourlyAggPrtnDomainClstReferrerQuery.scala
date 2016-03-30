package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyAggPrtnDomainClstReferrerQuery extends QueryBase[HourlyAggPrtnDomainClstReferrerQueryParams, HourlyAggPrtnDomainClstReferrerRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnDomainClstReferrerQueryParams = {
        val (partner_id,domain) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.syndicationDomain), params)
        HourlyAggPrtnDomainClstReferrerQueryParams(params.start, params.end, partner_id,domain, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnDomainClstReferrerQueryParams): Future[List[HourlyAggPrtnDomainClstReferrerRow]] = {
        val rawQueryResult = HourlyAggPrtnDomainClstReferrerTableAccessor.query(params.partnerIdList,params.domainList,params.metricList,params.years,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.syndicationDomain.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.referrer.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnDomainClstReferrerRow): List[String] = {
        List(row.partnerId.toString,row.domain.toString,row.metric.toString,row.hour.toString,row.referrer.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.syndicationDomain, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.referrer, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyAggPrtnDomainClstReferrerRow): String = row.metric
    }

case class HourlyAggPrtnDomainClstReferrerQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], domainList : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams