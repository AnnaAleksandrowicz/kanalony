package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyAggClstCv2TableAccessor extends CassandraTable[HourlyAggClstCv2TableAccessor, HourlyAggClstCv2Row] with RootConnector with IHourlyAggClstCv2TableAccessor {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object year extends IntColumn(this)with PartitionKey[Int]
object metric extends StringColumn(this)with PartitionKey[String]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object custom_var2 extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_agg_clst_cv2"

  def fromRow(row: Row): HourlyAggClstCv2Row = {
    HourlyAggClstCv2Row(
      partner_id(row), 
year(row), 
metric(row), 
hour(row), 
custom_var2(row), 
value(row)
    )
  }

  def store(entity: HourlyAggClstCv2Row): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.year, entity.year)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.custom_var2, entity.customVar2)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, year : Int, metric : String) : Future[List[HourlyAggClstCv2Row]] = {
    select.where(_.partner_id eqs partnerId).and(_.year eqs year)
.and(_.metric eqs metric)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggClstCv2Row]] = {
    select.where(_.partner_id eqs partnerId).and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime, customVar2Start : String, customVar2End : String) : Future[List[HourlyAggClstCv2Row]] = {
    select.where(_.partner_id eqs partnerId).and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.custom_var2 gte customVar2Start)
.and(_.custom_var2 lt customVar2End)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
def query(partnerIdList : List[Int], yearList : List[Int], metricList : List[String]) : Future[List[HourlyAggClstCv2Row]] = {
    select.where(_.partner_id in partnerIdList).and(_.year in yearList)
.and(_.metric in metricList)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggClstCv2Row]] = {
    select.where(_.partner_id in partnerIdList).and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime, customVar2Start : String, customVar2End : String) : Future[List[HourlyAggClstCv2Row]] = {
    select.where(_.partner_id in partnerIdList).and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.custom_var2 gte customVar2Start)
.and(_.custom_var2 lt customVar2End)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }

}

import org.joda.time.DateTime
case class HourlyAggClstCv2Row(partnerId:Int,
year:Int,
metric:String,
hour:DateTime,
customVar2:String,
value:Long)


import scala.concurrent.Future

trait IHourlyAggClstCv2TableAccessor {
  def query(partnerId : Int, year : Int, metric : String) : Future[List[HourlyAggClstCv2Row]]
 def query(partnerId : Int, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggClstCv2Row]]
 def query(partnerId : Int, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime, customVar2Start : String, customVar2End : String) : Future[List[HourlyAggClstCv2Row]]
def query(partnerIdList : List[Int], yearList : List[Int], metricList : List[String]) : Future[List[HourlyAggClstCv2Row]]
 def query(partnerIdList : List[Int], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggClstCv2Row]]
 def query(partnerIdList : List[Int], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime, customVar2Start : String, customVar2End : String) : Future[List[HourlyAggClstCv2Row]]
}