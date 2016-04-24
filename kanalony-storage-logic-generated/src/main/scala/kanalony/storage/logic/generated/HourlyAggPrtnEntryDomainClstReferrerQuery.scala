package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.{DateTimeZone, DateTime}
    import scala.concurrent.Future

    class HourlyAggPrtnEntryDomainClstReferrerQuery(accessor : IHourlyAggPrtnEntryDomainClstReferrerTableAccessor) extends QueryBase[HourlyAggPrtnEntryDomainClstReferrerQueryParams, HourlyAggPrtnEntryDomainClstReferrerRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnEntryDomainClstReferrerQueryParams = {
        val (partner_id,entry_id,domain) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.syndicationDomain), params)
        HourlyAggPrtnEntryDomainClstReferrerQueryParams(params.startUtc, params.endUtc, partner_id,entry_id,domain, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnEntryDomainClstReferrerQueryParams): Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]] = {
        accessor.query(params.partnerIdList,params.entryIdList,params.domainList,params.metricList,params.years,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.syndicationDomain.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.referrer.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnEntryDomainClstReferrerRow): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.domain.toString,row.metric.toString,row.hour.toString,row.referrer.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.syndicationDomain, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.referrer, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: HourlyAggPrtnEntryDomainClstReferrerRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : HourlyAggPrtnEntryDomainClstReferrerRow, timezoneOffsetFromUtc : Int) : HourlyAggPrtnEntryDomainClstReferrerRow = {
        HourlyAggPrtnEntryDomainClstReferrerRow(row.partnerId, row.entryId, row.domain, row.metric, row.year, row.hour.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.referrer, row.value)
      }

    }

case class HourlyAggPrtnEntryDomainClstReferrerQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], domainList : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams