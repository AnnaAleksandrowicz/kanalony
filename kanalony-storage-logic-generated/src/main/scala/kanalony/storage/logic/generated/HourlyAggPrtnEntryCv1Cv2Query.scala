package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyAggPrtnEntryCv1Cv2Query extends QueryBase[HourlyAggPrtnEntryCv1Cv2QueryParams, HourlyAggPrtnEntryCv1Cv2Row] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnEntryCv1Cv2QueryParams = {
        val (partner_id,entry_id,custom_var1,custom_var2) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.cf1,Dimensions.cf2), params)
        HourlyAggPrtnEntryCv1Cv2QueryParams(params.start, params.end, partner_id,entry_id,custom_var1,custom_var2, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnEntryCv1Cv2QueryParams): Future[List[HourlyAggPrtnEntryCv1Cv2Row]] = {
        val rawQueryResult = HourlyAggPrtnEntryCv1Cv2TableAccessor.query(params.partnerIdList,params.entryIdList,params.customVar1List,params.customVar2List,params.years,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.cf1.toString,Dimensions.cf2.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnEntryCv1Cv2Row): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.customVar1.toString,row.customVar2.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf1, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf2, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: HourlyAggPrtnEntryCv1Cv2Row): String = row.metric
    }

case class HourlyAggPrtnEntryCv1Cv2QueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], customVar1List : List[String], customVar2List : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams