package com.kaltura.aggregations.userActivity.hourly

import com.datastax.spark.connector.{SomeColumns, _}
import com.kaltura.aggregations.keys.UserActivityDomainReferrerKey
import com.kaltura.aggregations.IAggregateHourly
import com.kaltura.aggregations.userActivity.BaseUserActivityAggregation
import com.kaltura.model.events.EnrichedPlayerEvent
import kanalony.storage.generated.hourly_ua_ptrn_domain_clst_referrerRow


object HourlyUserActivityByDomainReferrer extends BaseUserActivityAggregation[UserActivityDomainReferrerKey, hourly_ua_ptrn_domain_clst_referrerRow] with IAggregateHourly with Serializable {

  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "hourly_ua_prtn_referrer" -> columns,
    "hourly_ua_clst_referrer" -> columns,
    "hourly_ua_prtn_domain_clst_referrer" -> SomeColumns(
      "partner_id" as "partnerId",
      "domain" as "domain",
      "referrer" as "referrer",
      "metric" as "metric",
      "hour" as "hour",
      "year" as "year",
      "value" as "value")
  )

  val columns : SomeColumns = SomeColumns(
    "partner_id" as "partnerId",
    "referrer" as "referrer",
    "metric" as "metric",
    "hour" as "hour",
    "year" as "year",
    "value" as "value")

  override def aggKey(e: EnrichedPlayerEvent): UserActivityDomainReferrerKey = UserActivityDomainReferrerKey(e.partnerId, e.eventType, e.eventTime.hourOfDay().roundFloorCopy(), e.urlParts.domain, e.urlParts.canonicalUrl)
  override def toRow(pair: (UserActivityDomainReferrerKey, Long)): hourly_ua_ptrn_domain_clst_referrerRow = hourly_ua_ptrn_domain_clst_referrerRow(pair._1.partnerId, pair._1.domain, pair._1.metric, pair._1.time.getYear, pair._1.time, pair._1.referrer, pair._2)
}
