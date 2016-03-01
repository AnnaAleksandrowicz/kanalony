package com.kaltura.aggregations.userActivity.hourly

import com.datastax.spark.connector.{SomeColumns, _}
import com.kaltura.aggregations.IAggregateHourly
import com.kaltura.aggregations.keys.{UserActivityCF1CF2CF3Key, UserActivityCF1CF2Key}
import com.kaltura.aggregations.userActivity.BaseUserActivityAggregation
import com.kaltura.model.events.EnrichedPlayerEvent
import kanalony.storage.generated.{hourly_user_activity_prtn_cf1_cf2_cf3Row, hourly_user_activity_prtn_cf1_cf2Row}


object HourlyUserActivityByCF1CF2CF3 extends BaseUserActivityAggregation[UserActivityCF1CF2CF3Key, hourly_user_activity_prtn_cf1_cf2_cf3Row] with IAggregateHourly with Serializable{

   override lazy val tableMetadata: Map[String, SomeColumns] = Map(
     "hourly_ua_prtn_cf1_cf2_cf3" -> columns,
     "hourly_ua_prtn_cf1_cf2_clst_cf3" -> columns
   )

   val columns : SomeColumns = new SomeColumns(
     "partner_id" as "partnerId",
     "cf1" as "cf1",
     "cf2" as "cf2",
     "cf3" as "cf3",
     "metric" as "metric",
     "hour" as "hour",
     "year" as "year",
     "value" as "value")


   override def aggKey(e: EnrichedPlayerEvent): UserActivityCF1CF2CF3Key = UserActivityCF1CF2CF3Key(e.partnerId, e.eventType, e.eventTime.hourOfDay().roundFloorCopy(), e.cf1, e.cf2, e.cf3)
   override def toRow(pair: (UserActivityCF1CF2CF3Key, Long)): hourly_user_activity_prtn_cf1_cf2_cf3Row = hourly_user_activity_prtn_cf1_cf2_cf3Row(pair._1.partnerId, pair._1.cf1, pair._1.cf2, pair._1.cf3, pair._1.metric, pair._1.time.getYear, pair._1.time, pair._2)
 }
