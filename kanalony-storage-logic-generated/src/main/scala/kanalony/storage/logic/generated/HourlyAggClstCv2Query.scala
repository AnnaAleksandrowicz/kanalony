package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class HourlyAggClstCv2Query extends QueryBase[HourlyAggClstCv2QueryParams, HourlyAggClstCv2Row] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggClstCv2QueryParams = {
        val (partner_id) = QueryParamsValidator.extractEqualityConstraintParams[Int]((Dimensions.partner), params)
        HourlyAggClstCv2QueryParams(params.start, params.end, partner_id, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggClstCv2QueryParams): Future[List[HourlyAggClstCv2Row]] = {
        val rawQueryResult = HourlyAggClstCv2TableAccessor.query(params.partnerIdList,params.years,params.metricList,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.cf2.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggClstCv2Row): List[String] = {
        List(row.partnerId.toString,row.metric.toString,row.hour.toString,row.customVar2.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.cf2, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: HourlyAggClstCv2Row): String = row.metric
    }

case class HourlyAggClstCv2QueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], metricList : List[String]) extends IYearlyPartitionedQueryParams