package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class TensecsAggPrtnCategoryQuery extends QueryBase[TensecsAggPrtnCategoryQueryParams, TensecsAggPrtnCategoryRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): TensecsAggPrtnCategoryQueryParams = {
        val (partner_id,category) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.category), params)
        TensecsAggPrtnCategoryQueryParams(params.start, params.end, partner_id,category, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: TensecsAggPrtnCategoryQueryParams): Future[List[TensecsAggPrtnCategoryRow]] = {
        val rawQueryResult = TensecsAggPrtnCategoryTableAccessor.query(params.partnerIdList,params.categoryList,params.metricList,params.days,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.category.toString,Dimensions.metric.toString,Dimensions.tenSeconds.toString,"value")
      }

      override protected def getResultRow(row: TensecsAggPrtnCategoryRow): List[String] = {
        List(row.partnerId.toString,row.category.toString,row.metric.toString,row.tensecs.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.category, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.tenSeconds, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: TensecsAggPrtnCategoryRow): String = row.metric
    }

case class TensecsAggPrtnCategoryQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], categoryList : List[String], metricList : List[String]) extends IDailyPartitionedQueryParams