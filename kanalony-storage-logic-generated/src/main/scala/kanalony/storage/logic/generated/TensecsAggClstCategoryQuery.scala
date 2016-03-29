package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class TensecsAggClstCategoryQuery extends QueryBase[TensecsAggClstCategoryQueryParams, TensecsAggClstCategoryRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): TensecsAggClstCategoryQueryParams = {
        val (partner_id) = QueryParamsValidator.extractEqualityConstraintParams[Int]((Dimensions.partner), params)
        TensecsAggClstCategoryQueryParams(params.start, params.end, partner_id, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: TensecsAggClstCategoryQueryParams): Future[List[TensecsAggClstCategoryRow]] = {
        val rawQueryResult = TensecsAggClstCategoryTableAccessor.query(params.partnerIdList,params.metricList,params.days,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.metric.toString,Dimensions.tenSeconds.toString,Dimensions.category.toString,"value")
      }

      override protected def getResultRow(row: TensecsAggClstCategoryRow): List[String] = {
        List(row.partnerId.toString,row.metric.toString,row.tensecs.toString,row.category.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.tenSeconds, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.category, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: TensecsAggClstCategoryRow): String = row.metric
    }

case class TensecsAggClstCategoryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], metricList : List[String]) extends IDailyPartitionedQueryParams