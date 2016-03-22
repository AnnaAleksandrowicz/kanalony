package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class minutely_ua_prtn_categoryQuery extends QueryBase[minutely_ua_prtn_categoryQueryParams, minutely_ua_prtn_categoryRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): minutely_ua_prtn_categoryQueryParams = {
        val (partner_id,category) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.category), params)
        minutely_ua_prtn_categoryQueryParams(params.start, params.end, partner_id,category, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: minutely_ua_prtn_categoryQueryParams): Future[List[minutely_ua_prtn_categoryRow]] = {
        val rawQueryResult = minutely_ua_prtn_categoryTableAccessor.query(params.partner_id_list,params.category_list,params.metric_list,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.category.toString,Dimensions.metric.toString,Dimensions.minute.toString,"value")
      }

      override protected def getResultRow(row: minutely_ua_prtn_categoryRow): List[String] = {
        List(row.partner_id.toString,row.category.toString,row.metric.toString,row.minute.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.category, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: minutely_ua_prtn_categoryRow): Int = row.metric
    }

case class minutely_ua_prtn_categoryQueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], category_list : List[String], metric_list : List[Int]) 