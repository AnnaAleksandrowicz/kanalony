package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.{DateTimeZone, DateTime}
    import scala.concurrent.Future

    class TensecsAggPrtnEntryCountryCityQuery(accessor : ITensecsAggPrtnEntryCountryCityTableAccessor) extends QueryBase[TensecsAggPrtnEntryCountryCityQueryParams, TensecsAggPrtnEntryCountryCityRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): TensecsAggPrtnEntryCountryCityQueryParams = {
        val (partner_id,entry_id,country,city) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.country,Dimensions.city), params)
        TensecsAggPrtnEntryCountryCityQueryParams(params.startUtc, params.endUtc, partner_id,entry_id,country,city, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: TensecsAggPrtnEntryCountryCityQueryParams): Future[List[TensecsAggPrtnEntryCountryCityRow]] = {
        accessor.query(params.partnerIdList,params.entryIdList,params.countryList,params.cityList,params.metricList,params.days,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.country.toString,Dimensions.city.toString,Dimensions.metric.toString,Dimensions.tenSeconds.toString,"value")
      }

      override protected def getResultRow(row: TensecsAggPrtnEntryCountryCityRow): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.country.toString,row.city.toString,row.metric.toString,row.tensecs.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.city, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.tenSeconds, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: TensecsAggPrtnEntryCountryCityRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : TensecsAggPrtnEntryCountryCityRow, timezoneOffsetFromUtc : Int) : TensecsAggPrtnEntryCountryCityRow = {
        TensecsAggPrtnEntryCountryCityRow(row.partnerId, row.entryId, row.country, row.city, row.metric, row.day, row.tensecs.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.value)
      }

    }

case class TensecsAggPrtnEntryCountryCityQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], countryList : List[String], cityList : List[String], metricList : List[String]) extends IDailyPartitionedQueryParams