package kanalony.storage.generated

import com.websudos.phantom.builder._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.dsl._

import scala.concurrent.Future

abstract class minutely_user_activity_clst_applicationTableAccessor extends CassandraTable[minutely_user_activity_clst_applicationTableAccessor, minutely_user_activity_clst_applicationRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object application extends StringColumn(this)with ClusteringOrder[String] with Ascending
object count extends LongColumn(this)


  override def tableName = "minutely_user_activity_clst_application"

  def fromRow(row: Row): minutely_user_activity_clst_applicationRow = {
    minutely_user_activity_clst_applicationRow(
      partner_id(row), 
metric(row), 
minute(row), 
application(row), 
count(row)
    )
  }

  def store(entity: minutely_user_activity_clst_applicationRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.application, entity.application)
.value(_.count, entity.count)

      .future()
  }

  def query(partner_id : Int, metric : Int) : SelectQuery[minutely_user_activity_clst_applicationTableAccessor, minutely_user_activity_clst_applicationRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
  }
 def query(partner_id : Int, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_clst_applicationTableAccessor, minutely_user_activity_clst_applicationRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partner_id : Int, metric : Int, minuteStart : DateTime, minuteEnd : DateTime, applicationStart : String, applicationEnd : String) : SelectQuery[minutely_user_activity_clst_applicationTableAccessor, minutely_user_activity_clst_applicationRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.application gte applicationStart)
.and(_.application lt applicationEnd)
  }
def query(partner_id_list : List[Int], metric_list : List[Int]) : SelectQuery[minutely_user_activity_clst_applicationTableAccessor, minutely_user_activity_clst_applicationRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_clst_applicationTableAccessor, minutely_user_activity_clst_applicationRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partner_id_list : List[Int], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime, applicationStart : String, applicationEnd : String) : SelectQuery[minutely_user_activity_clst_applicationTableAccessor, minutely_user_activity_clst_applicationRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.application gte applicationStart)
.and(_.application lt applicationEnd)
  }

}