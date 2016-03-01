package com.kaltura.aggregations.userActivity.hourly

import com.datastax.spark.connector.{SomeColumns, _}
import com.kaltura.aggregations.IAggregateHourly
import com.kaltura.aggregations.keys.{UserActivityApplicationKey, UserActivityCountryKey}
import com.kaltura.aggregations.userActivity.BaseUserActivityAggregation
import com.kaltura.model.aggregations.{HourlyPartnerApplication, HourlyPartnerCountry}
import com.kaltura.model.events.EnrichedPlayerEvent


object HourlyUserActivityByApplication extends BaseUserActivityAggregation[UserActivityApplicationKey, HourlyPartnerApplication] with IAggregateHourly with Serializable{

   override lazy val tableMetadata: Map[String, SomeColumns] = Map(
     "hourly_ua_prtn_app" -> columns,
     "hourly_ua_clst_app" -> columns
   )

   val columns : SomeColumns = new SomeColumns(
     "partner_id" as "partnerId",
     "application" as "application",
     "metric" as "metric",
     "hour" as "hour",
     "year" as "year",
     "value" as "value")

   override def aggKey(e: EnrichedPlayerEvent): UserActivityApplicationKey = UserActivityApplicationKey(e.partnerId, e.eventType, e.eventTime.hourOfDay().roundFloorCopy(), e.application)
   override def toRow(pair: (UserActivityApplicationKey, Long)): HourlyPartnerApplication = HourlyPartnerApplication(pair._1.partnerId, pair._1.metric, pair._1.time.getYear, pair._1.time, pair._1.application, pair._2)


 }
