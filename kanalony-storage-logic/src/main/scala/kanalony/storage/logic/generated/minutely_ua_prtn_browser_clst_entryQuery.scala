package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class minutely_ua_prtn_browser_clst_entryQuery extends QueryBase[minutely_ua_prtn_browser_clst_entryQueryParams, minutely_ua_prtn_browser_clst_entryRow] with UserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): minutely_ua_prtn_browser_clst_entryQueryParams = {
        val (partner_id,browser) = QueryParamsValidator.extractEqualityConstraintParams[Int,Int]((Dimensions.partner,Dimensions.browser), params)
        minutely_ua_prtn_browser_clst_entryQueryParams(params.start, params.end, partner_id,browser, params.metrics.map(_.id))
      }

      private[logic] override def executeQuery(params: minutely_ua_prtn_browser_clst_entryQueryParams): Future[List[minutely_ua_prtn_browser_clst_entryRow]] = {
        val rawQueryResult = minutely_ua_prtn_browser_clst_entryTableAccessor.query(params.partner_id_list,params.browser_list,params.metric_list,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.browser.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.entry.toString,"value")
      }

      override protected def getResultRow(row: minutely_ua_prtn_browser_clst_entryRow): List[String] = {
        List(row.partner_id.toString,row.browser.toString,row.metric.toString,row.minute.toString,row.entry_id.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: minutely_ua_prtn_browser_clst_entryRow): Int = row.metric
    }

case class minutely_ua_prtn_browser_clst_entryQueryParams(startTime : DateTime, endTime : DateTime, partner_id_list : List[Int], browser_list : List[Int], metric_list : List[Int]) 