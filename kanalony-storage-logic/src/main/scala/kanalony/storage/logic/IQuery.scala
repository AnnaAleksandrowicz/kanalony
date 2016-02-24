package kanalony.storage.logic

import kanalony.storage.logic.queries.model.DimensionDefinition

import scala.concurrent.Future

/**
 * Created by elad.benedict on 2/10/2016.
 */

trait IQuery {
  def tableName : String
  val supportedMetrics : Set[Metrics.Value]
  val dimensionInformation : List[DimensionDefinition]
  def query(params : QueryParams) : Future[IQueryResult]
}
