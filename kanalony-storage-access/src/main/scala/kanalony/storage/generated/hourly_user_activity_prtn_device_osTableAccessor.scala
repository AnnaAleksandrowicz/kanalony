package kanalony.storage.generated

import com.websudos.phantom.builder._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.dsl._

import scala.concurrent.Future

abstract class hourly_user_activity_prtn_device_osTableAccessor extends CassandraTable[hourly_user_activity_prtn_device_osTableAccessor, hourly_user_activity_prtn_device_osRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object device extends StringColumn(this)with PartitionKey[String]
object os extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object year extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object count extends LongColumn(this)


  override def tableName = "hourly_user_activity_prtn_device_os"

  def fromRow(row: Row): hourly_user_activity_prtn_device_osRow = {
    hourly_user_activity_prtn_device_osRow(
      partner_id(row), 
device(row), 
os(row), 
metric(row), 
year(row), 
hour(row), 
count(row)
    )
  }

  def store(entity: hourly_user_activity_prtn_device_osRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.device, entity.device)
.value(_.os, entity.os)
.value(_.metric, entity.metric)
.value(_.year, entity.year)
.value(_.hour, entity.hour)
.value(_.count, entity.count)

      .future()
  }

  def query(partner_id : Int, device : String, os : String, metric : Int, year : Int) : SelectQuery[hourly_user_activity_prtn_device_osTableAccessor, hourly_user_activity_prtn_device_osRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.device eqs device)
.and(_.os eqs os)
.and(_.metric eqs metric)
.and(_.year eqs year)
  }
 def query(partner_id : Int, device : String, os : String, metric : Int, year : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[hourly_user_activity_prtn_device_osTableAccessor, hourly_user_activity_prtn_device_osRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.device eqs device)
.and(_.os eqs os)
.and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
def query(partner_id_list : List[Int], device_list : List[String], os_list : List[String], metric_list : List[Int], year_list : List[Int]) : SelectQuery[hourly_user_activity_prtn_device_osTableAccessor, hourly_user_activity_prtn_device_osRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.device in device_list)
.and(_.os in os_list)
.and(_.metric in metric_list)
.and(_.year in year_list)
  }
 def query(partner_id_list : List[Int], device_list : List[String], os_list : List[String], metric_list : List[Int], year_list : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[hourly_user_activity_prtn_device_osTableAccessor, hourly_user_activity_prtn_device_osRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.device in device_list)
.and(_.os in os_list)
.and(_.metric in metric_list)
.and(_.year in year_list)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }

}