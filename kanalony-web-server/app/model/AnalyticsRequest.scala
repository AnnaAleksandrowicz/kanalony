package model

/**
 * Created by elad.benedict on 2/21/2016.
 */
case class AnalyticsRequest(from: Long, to : Long, dimensions: List[String], filters : List[EqualityFilter], metrics : List[String], utcOffset : Int = 0)
