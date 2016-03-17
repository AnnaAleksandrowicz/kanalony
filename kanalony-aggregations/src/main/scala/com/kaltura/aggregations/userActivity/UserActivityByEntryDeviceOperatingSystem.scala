package com.kaltura.aggregations.userActivity

import com.datastax.spark.connector.{SomeColumns, _}
import com.kaltura.aggregations.{IAggregateTenSecs, IAggregateMinutely, IAggregate, IAggregateHourly}
import com.kaltura.aggregations.keys.UserActivityEntryDeviceOperatingSystemKey
import com.kaltura.model.events.EnrichedPlayerEvent
import org.joda.time.DateTime
import com.kaltura.core.utils.ReadableDateUnits.ReadableDateUnits


abstract class UserActivityByEntryDeviceOperatingSystem extends BaseUserActivityAggregation[UserActivityEntryDeviceOperatingSystemKey, EntryDeviceOperatingSystemRes] with IAggregate with Serializable {

  val columns: List[(String, String)] = List[(String, String)](
    ("partner_id","partnerId"),
    ("entry_id","entryId"),
    ("device","device"),
    ("operating_system", "operatingSystem"),
    ("metric","metric"),
    (getAggrTimeUnit,"time"),
    ("value","value"))

  override def aggKey(e: EnrichedPlayerEvent): UserActivityEntryDeviceOperatingSystemKey = UserActivityEntryDeviceOperatingSystemKey(e.partnerId, e.entryId, e.eventType, getAggrTime(e.eventTime), e.userAgent.device.id, e.userAgent.operatingSystem.id)
  override def toRow(pair: (UserActivityEntryDeviceOperatingSystemKey, Long)): EntryDeviceOperatingSystemRes = EntryDeviceOperatingSystemRes(partnerId = pair._1.partnerId, entryId = pair._1.entryId, device = pair._1.device, operatingSystem = pair._1.operatingSystem, metric = pair._1.metric, year = pair._1.time getYear, month = pair._1.time getYearMonth, day = pair._1.time getYearMonthDay, time = pair._1.time, value = pair._2)


}

object HourlyUserActivityByEntryDeviceOperatingSystem extends UserActivityByEntryDeviceOperatingSystem with IAggregateHourly {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "hourly_ua_prtn_entry_device_os" -> toSomeColumns(columns :+ ("year", "year")),
    "hourly_ua_prtn_entry_device_clst_os" -> toSomeColumns(columns :+ ("year", "year")),
    "hourly_ua_prtn_device_os_clst_entry" -> toSomeColumns(columns :+ ("month", "month"))
  )
}

object MinutelyUserActivityByEntryDeviceOperatingSystem extends UserActivityByEntryDeviceOperatingSystem with IAggregateMinutely {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "minutely_ua_prtn_entry_device_os" -> toSomeColumns(columns),
    "minutely_ua_prtn_entry_device_clst_os" -> toSomeColumns(columns),
    "minutely_ua_prtn_device_os_clst_entry" -> toSomeColumns(columns :+ ("day", "day"))

  )
}

object TenSecsUserActivityByEntryDeviceOperatingSystem extends UserActivityByEntryDeviceOperatingSystem with IAggregateTenSecs {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "tensecs_ua_prtn_entry_device_os" -> toSomeColumns(columns),
    "tensecs_ua_prtn_entry_device_clst_os" -> toSomeColumns(columns)
  )
}
case class EntryDeviceOperatingSystemRes(partnerId: Int, entryId: String, metric: Int, year: Int, month: Int, day: Int, time: DateTime, device: Int, operatingSystem: Int, value: Long)

