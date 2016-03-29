package kanalony.storage.logic

import com.kaltura.model.entities.{Metric, AggregationKind, Metrics}
import kanalony.storage.logic.queries.{DailyMaxQuery, DailyCountQuery}

/**
 * Created by elad.benedict on 3/7/2016.
 */

object ComputedDimensions extends ComputedQueryFactory[Dimensions.Value] {

  val queryCreatorGetter = Map((Dimensions.day, dailyQueryCreator))

  def dailyQueryCreator : (QueryParams) => List[(IQuery, List[Metric])] = {
    (qp) => {
      var res : List[(IQuery, List[Metric])] = List()
      val dailyMaxMetrics = qp.metrics.filter(_.aggregationKind == AggregationKind.Max)
      if (dailyMaxMetrics.nonEmpty)
      {
        res = res :+ (new DailyMaxQuery(qp), dailyMaxMetrics)
      }

      val dailyCountMetrics = qp.metrics.filter(_.aggregationKind == AggregationKind.Sum)
      if (dailyCountMetrics.nonEmpty)
      {
        res = res :+ (new DailyCountQuery(qp), dailyCountMetrics)
      }

      res
    }
  }

  override def getErrorMessage(value: Dimensions.Value): String = s"Computed dimension ${value} is currently not supported"

}