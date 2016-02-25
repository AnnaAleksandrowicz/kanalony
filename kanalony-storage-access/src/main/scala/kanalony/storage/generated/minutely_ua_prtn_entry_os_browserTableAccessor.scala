package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import scala.concurrent.Future

abstract class minutely_ua_prtn_entry_os_browserTableAccessor extends CassandraTable[minutely_ua_prtn_entry_os_browserTableAccessor, minutely_ua_prtn_entry_os_browserRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object os extends StringColumn(this)with PartitionKey[String]
object browser extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "minutely_ua_prtn_entry_os_browser"

  def fromRow(row: Row): minutely_ua_prtn_entry_os_browserRow = {
    minutely_ua_prtn_entry_os_browserRow(
      partner_id(row), 
entry_id(row), 
os(row), 
browser(row), 
metric(row), 
minute(row), 
value(row)
    )
  }

  def store(entity: minutely_ua_prtn_entry_os_browserRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.entry_id, entity.entry_id)
.value(_.os, entity.os)
.value(_.browser, entity.browser)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.value, entity.value)

      .future()
  }

  def query(partner_id : Int, entry_id : String, os : String, browser : String, metric : Int) : SelectQuery[minutely_ua_prtn_entry_os_browserTableAccessor, minutely_ua_prtn_entry_os_browserRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.os eqs os)
.and(_.browser eqs browser)
.and(_.metric eqs metric)
  }
 def query(partner_id : Int, entry_id : String, os : String, browser : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_prtn_entry_os_browserTableAccessor, minutely_ua_prtn_entry_os_browserRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.os eqs os)
.and(_.browser eqs browser)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
def query(partner_id_list : List[Int], entry_id_list : List[String], os_list : List[String], browser_list : List[String], metric_list : List[Int]) : SelectQuery[minutely_ua_prtn_entry_os_browserTableAccessor, minutely_ua_prtn_entry_os_browserRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.os in os_list)
.and(_.browser in browser_list)
.and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], entry_id_list : List[String], os_list : List[String], browser_list : List[String], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_prtn_entry_os_browserTableAccessor, minutely_ua_prtn_entry_os_browserRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.os in os_list)
.and(_.browser in browser_list)
.and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }

}