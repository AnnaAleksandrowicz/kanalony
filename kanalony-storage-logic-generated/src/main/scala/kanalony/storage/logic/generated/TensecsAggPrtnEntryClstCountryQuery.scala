package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.{DateTimeZone, DateTime}
    import scala.concurrent.Future

    class TensecsAggPrtnEntryClstCountryQuery(accessor : ITensecsAggPrtnEntryClstCountryTableAccessor) extends QueryBase[TensecsAggPrtnEntryClstCountryQueryParams, TensecsAggPrtnEntryClstCountryRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): TensecsAggPrtnEntryClstCountryQueryParams = {
        val (partner_id,entry_id) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.entry), params)
        TensecsAggPrtnEntryClstCountryQueryParams(params.startUtc, params.endUtc, partner_id,entry_id, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: TensecsAggPrtnEntryClstCountryQueryParams): Future[List[TensecsAggPrtnEntryClstCountryRow]] = {
        accessor.query(params.partnerIdList,params.entryIdList,params.metricList,params.days,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.metric.toString,Dimensions.tenSeconds.toString,Dimensions.country.toString,"value")
      }

      override protected def getResultRow(row: TensecsAggPrtnEntryClstCountryRow): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.metric.toString,row.tensecs.toString,row.country.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.tenSeconds, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: TensecsAggPrtnEntryClstCountryRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : TensecsAggPrtnEntryClstCountryRow, timezoneOffsetFromUtc : Int) : TensecsAggPrtnEntryClstCountryRow = {
        TensecsAggPrtnEntryClstCountryRow(row.partnerId, row.entryId, row.metric, row.day, row.tensecs.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.country, row.value)
      }

    }

case class TensecsAggPrtnEntryClstCountryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], metricList : List[String]) extends IDailyPartitionedQueryParams