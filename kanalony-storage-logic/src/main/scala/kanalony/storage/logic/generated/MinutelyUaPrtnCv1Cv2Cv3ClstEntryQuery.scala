package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class MinutelyUaPrtnCv1Cv2Cv3ClstEntryQuery extends QueryBase[MinutelyUaPrtnCv1Cv2Cv3ClstEntryQueryParams, MinutelyUaPrtnCv1Cv2Cv3ClstEntryRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyUaPrtnCv1Cv2Cv3ClstEntryQueryParams = {
        val (partner_id,custom_var1,custom_var2,custom_var3) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String,String]((Dimensions.partner,Dimensions.cf1,Dimensions.cf2,Dimensions.cf3), params)
        MinutelyUaPrtnCv1Cv2Cv3ClstEntryQueryParams(params.start, params.end, partner_id,custom_var1,custom_var2,custom_var3, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: MinutelyUaPrtnCv1Cv2Cv3ClstEntryQueryParams): Future[List[MinutelyUaPrtnCv1Cv2Cv3ClstEntryRow]] = {
        val rawQueryResult = MinutelyUaPrtnCv1Cv2Cv3ClstEntryTableAccessor.query(params.partnerIdList,params.customVar1List,params.customVar2List,params.customVar3List,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.cf1.toString,Dimensions.cf2.toString,Dimensions.cf3.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.entry.toString,"value")
      }

      override protected def getResultRow(row: MinutelyUaPrtnCv1Cv2Cv3ClstEntryRow): List[String] = {
        List(row.partnerId.toString,row.customVar1.toString,row.customVar2.toString,row.customVar3.toString,row.metric.toString,row.minute.toString,row.entryId.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf1, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf2, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf3, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 7

      override private[logic] def extractMetric(row: MinutelyUaPrtnCv1Cv2Cv3ClstEntryRow): Int = row.metric
    }

case class MinutelyUaPrtnCv1Cv2Cv3ClstEntryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], customVar1List : List[String], customVar2List : List[String], customVar3List : List[String], metricList : List[Int]) 