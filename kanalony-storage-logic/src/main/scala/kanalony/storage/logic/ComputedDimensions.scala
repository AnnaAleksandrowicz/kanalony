package kanalony.storage.logic

import com.kaltura.model.entities.InternalMetrics
import kanalony.storage.logic.queries.DailyQuery

/**
 * Created by elad.benedict on 3/7/2016.
 */

object ComputedDimensions extends ComputedQueryFactory[Dimensions.Value] {

  val queryCreatorGetter = Map((Dimensions.day, dailyQueryCreator))

  def dailyQueryCreator : (QueryParams) => List[(IQuery, List[InternalMetrics.Value])] = {
    (qp) => List((new DailyQuery(qp), qp.metrics))
  }

  override def getErrorMessage(value: Dimensions.Value): String = s"Computed dimension ${value} is currently not supported"
}