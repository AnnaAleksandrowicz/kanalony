package kanalony.storage.generated

import com.websudos.phantom.builder._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.dsl._

import scala.concurrent.Future

abstract class minutely_user_activity_prtn_osTableAccessor extends CassandraTable[minutely_user_activity_prtn_osTableAccessor, minutely_user_activity_prtn_osRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object os extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object count extends LongColumn(this)


  override def tableName = "minutely_user_activity_prtn_os"

  def fromRow(row: Row): minutely_user_activity_prtn_osRow = {
    minutely_user_activity_prtn_osRow(
      partner_id(row), 
os(row), 
metric(row), 
minute(row), 
count(row)
    )
  }

  def store(entity: minutely_user_activity_prtn_osRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.os, entity.os)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.count, entity.count)

      .future()
  }

  def query(partner_id : Int, os : String, metric : Int) : SelectQuery[minutely_user_activity_prtn_osTableAccessor, minutely_user_activity_prtn_osRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.os eqs os)
.and(_.metric eqs metric)
  }
 def query(partner_id : Int, os : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_prtn_osTableAccessor, minutely_user_activity_prtn_osRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.os eqs os)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
def query(partner_id_list : List[Int], os_list : List[String], metric_list : List[Int]) : SelectQuery[minutely_user_activity_prtn_osTableAccessor, minutely_user_activity_prtn_osRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.os in os_list)
.and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], os_list : List[String], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_prtn_osTableAccessor, minutely_user_activity_prtn_osRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.os in os_list)
.and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }

}