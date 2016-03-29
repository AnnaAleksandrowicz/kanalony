package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyAggPrtnCv1Query extends QueryBase[HourlyAggPrtnCv1QueryParams, HourlyAggPrtnCv1Row] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnCv1QueryParams = {
        val (partner_id,custom_var1) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.cf1), params)
        HourlyAggPrtnCv1QueryParams(params.start, params.end, partner_id,custom_var1, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnCv1QueryParams): Future[List[HourlyAggPrtnCv1Row]] = {
        val rawQueryResult = HourlyAggPrtnCv1TableAccessor.query(params.partnerIdList,params.customVar1List,params.years,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.cf1.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnCv1Row): List[String] = {
        List(row.partnerId.toString,row.customVar1.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.cf1, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: HourlyAggPrtnCv1Row): String = row.metric
    }

case class HourlyAggPrtnCv1QueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], customVar1List : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams