package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyUaPrtnEntryCv1Cv2Cv3Query extends QueryBase[HourlyUaPrtnEntryCv1Cv2Cv3QueryParams, HourlyUaPrtnEntryCv1Cv2Cv3Row] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyUaPrtnEntryCv1Cv2Cv3QueryParams = {
        val (partner_id,custom_var1,entry_id,custom_var2,custom_var3) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String,String,String]((Dimensions.partner,Dimensions.cf1,Dimensions.entry,Dimensions.cf2,Dimensions.cf3), params)
        HourlyUaPrtnEntryCv1Cv2Cv3QueryParams(params.start, params.end, partner_id,custom_var1,entry_id,custom_var2,custom_var3, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: HourlyUaPrtnEntryCv1Cv2Cv3QueryParams): Future[List[HourlyUaPrtnEntryCv1Cv2Cv3Row]] = {
        val rawQueryResult = HourlyUaPrtnEntryCv1Cv2Cv3TableAccessor.query(params.partnerIdList,params.customVar1List,params.entryIdList,params.customVar2List,params.customVar3List,params.years,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.cf1.toString,Dimensions.entry.toString,Dimensions.cf2.toString,Dimensions.cf3.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: HourlyUaPrtnEntryCv1Cv2Cv3Row): List[String] = {
        List(row.partnerId.toString,row.customVar1.toString,row.entryId.toString,row.customVar2.toString,row.customVar3.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf1, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf2, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf3, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 7

      override private[logic] def extractMetric(row: HourlyUaPrtnEntryCv1Cv2Cv3Row): Int = row.metric
    }

case class HourlyUaPrtnEntryCv1Cv2Cv3QueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], customVar1List : List[String], entryIdList : List[String], customVar2List : List[String], customVar3List : List[String], metricList : List[Int]) extends IYearlyPartitionedQueryParams