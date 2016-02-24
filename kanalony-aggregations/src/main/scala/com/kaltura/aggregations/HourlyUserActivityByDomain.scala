package com.kaltura.aggregations

import com.datastax.spark.connector.{SomeColumns, _}
import com.kaltura.model.aggregations.{HourlyPartnerDomain, HourlyPartnerCountry}
import com.kaltura.model.events.EnrichedPlayerEvent
import org.apache.spark.streaming.dstream.{DStream, MapWithStateDStream}
import org.apache.spark.streaming.{State, Time}


object HourlyUserActivityByDomain extends BaseEventsAggregation[UserActivityDomainKey, HourlyPartnerDomain] with IAggregateHourly {

  override def tableMetadata(): Map[String, SomeColumns] = Map(
    "hourly_ua_prtn_domain" -> columns(),
    "hourly_ua_clst_domain" -> columns()
    )

  override def trackStateFunc(batchTime: Time, key: UserActivityDomainKey, value: Option[Long], state: State[Long]): Option[(UserActivityDomainKey, Long)] = {
    val sum = value.getOrElse(0L) + state.getOption.getOrElse(0L)
    val output = (key, sum)
    if (!state.isTimingOut())
      state.update(sum)
    Some(output)
  }

  override def aggregateBatchEvents(enrichedEvents: DStream[EnrichedPlayerEvent]): DStream[(UserActivityDomainKey, Long)] =
    enrichedEvents.map(x => (UserActivityDomainKey(x.partnerId, x.eventType, x.eventTime.hourOfDay().roundFloorCopy(), x.urlParts.domain),1L)).reduceByKey(_ + _)

  override def prepareForSave(aggregatedEvents: MapWithStateDStream[UserActivityDomainKey, Long, Long, (UserActivityDomainKey, Long)]): DStream[HourlyPartnerDomain] =
    aggregatedEvents.map({ case (k,v) => HourlyPartnerDomain(k.partnerId, k.metric, k.time.getYear, k.time, k.domain, v)})

  override def ttl(): Int = 60*60 + 5*60

  def columns() : SomeColumns = new SomeColumns(
    "partner_id" as "partnerId",
    "domain" as "domain",
    "metric" as "metric",
    "hour" as "hour",
    "year" as "year",
    "value" as "value")
}
