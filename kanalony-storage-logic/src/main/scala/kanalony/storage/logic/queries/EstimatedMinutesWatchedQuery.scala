package kanalony.storage.logic.queries

import com.kaltura.model.entities.InternalMetrics
import kanalony.storage.logic._
import kanalony.storage.logic.queries.model.IDimensionDefinition
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * Created by elad.benedict on 3/14/2016.
 */

class EstimatedMinutesWatchedQuery(queryParams: QueryParams) extends ComputedQuery(InternalMetrics.estimatedMinutesWatched, queryParams) {
  override val requiredMetrics: List[InternalMetrics.Value] = List(InternalMetrics.tenSecsViewed)

  override def computeValue(groupMetricsValues: List[SingleMetricValue]): Double = {
    groupMetricsValues.head.value / 6
  }
}
