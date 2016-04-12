package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class MinutelyAggPrtnCv1ClstEntryQuery(accessor : IMinutelyAggPrtnCv1ClstEntryTableAccessor) extends QueryBase[MinutelyAggPrtnCv1ClstEntryQueryParams, MinutelyAggPrtnCv1ClstEntryRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnCv1ClstEntryQueryParams = {
        val (partner_id,custom_var1) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.cf1), params)
        MinutelyAggPrtnCv1ClstEntryQueryParams(params.startUtc, params.endUtc, partner_id,custom_var1, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnCv1ClstEntryQueryParams): Future[List[MinutelyAggPrtnCv1ClstEntryRow]] = {
        accessor.query(params.partnerIdList,params.customVar1List,params.days,params.metricList,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.cf1.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.entry.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnCv1ClstEntryRow): List[String] = {
        List(row.partnerId.toString,row.customVar1.toString,row.metric.toString,row.minute.toString,row.entryId.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf1, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: MinutelyAggPrtnCv1ClstEntryRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : MinutelyAggPrtnCv1ClstEntryRow, timezoneOffsetFromUtc : Int) : MinutelyAggPrtnCv1ClstEntryRow = {
        MinutelyAggPrtnCv1ClstEntryRow(row.partnerId, row.customVar1, row.day, row.metric, row.minute.plusHours(timezoneOffsetFromUtc), row.entryId, row.value)
      }

    }

case class MinutelyAggPrtnCv1ClstEntryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], customVar1List : List[String], metricList : List[String]) extends IDailyPartitionedQueryParams