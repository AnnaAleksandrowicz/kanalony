package com.kaltura.aggregations.userActivity

import com.datastax.spark.connector.{SomeColumns, _}
import com.kaltura.aggregations.{IAggregateTenSecs, IAggregateMinutely, IAggregate, IAggregateHourly}
import com.kaltura.aggregations.keys.UserActivityEntryDomainKey
import com.kaltura.model.events.EnrichedPlayerEvent
import org.joda.time.DateTime
import com.kaltura.core.utils.ReadableDateUnits.ReadableDateUnits

abstract class UserActivityByEntryDomain extends BaseUserActivityAggregation[UserActivityEntryDomainKey, EntryDomainRes] with IAggregate with Serializable {

  val columns: List[(String, String)] = List[(String, String)](
    ("partner_id","partnerId"),
    ("entry_id","entryId"),
    ("domain","domain"),
    ("metric","metric"),
    (getAggrTimeUnit,"time"),
    ("value","value"))

  override def aggKey(e: EnrichedPlayerEvent): UserActivityEntryDomainKey = UserActivityEntryDomainKey(e.partnerId, e.entryId, e.eventType, getAggrTime(e.eventTime), e.urlParts.domain)
  override def toRow(pair: (UserActivityEntryDomainKey, Long)): EntryDomainRes = EntryDomainRes(partnerId = pair._1.partnerId, entryId = pair._1.entryId, domain = pair._1.domain, metric = pair._1.metric, year = pair._1.time getYear, month = pair._1.time getYearMonth, day = pair._1.time getYearMonthDay, time = pair._1.time, value = pair._2)
}

object HourlyUserActivityByEntryDomain extends UserActivityByEntryDomain with IAggregateHourly {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "hourly_ua_prtn_entry_domain" -> toSomeColumns(columns :+ ("year", "year")),
    "hourly_ua_prtn_entry_clst_domain" -> toSomeColumns(columns :+ ("year", "year")),
    "hourly_ua_prtn_domain_clst_entry" -> toSomeColumns(columns :+ ("month", "month"))
  )
}

object MinutelyUserActivityByEntryDomain extends UserActivityByEntryDomain with IAggregateMinutely {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "minutely_ua_prtn_entry_domain" -> toSomeColumns(columns),
    "minutely_ua_prtn_entry_clst_domain" -> toSomeColumns(columns),
    "minutely_ua_prtn_domain_clst_entry" -> toSomeColumns(columns :+ ("day", "day"))
  )
}

object TenSecsUserActivityByEntryDomain extends UserActivityByEntryDomain with IAggregateTenSecs {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "tensecs_ua_prtn_entry_domain" -> toSomeColumns(columns),
    "tensecs_ua_prtn_entry_clst_domain" -> toSomeColumns(columns)
  )
}
case class EntryDomainRes(partnerId: Int, entryId: String, metric: Int, year: Int, month: Int, day: Int, time: DateTime, domain: String, value: Long)

