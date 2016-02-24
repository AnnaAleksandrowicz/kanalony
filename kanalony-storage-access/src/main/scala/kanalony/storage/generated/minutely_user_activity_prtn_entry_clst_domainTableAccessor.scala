package kanalony.storage.generated

import com.websudos.phantom.builder._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.dsl._

import scala.concurrent.Future

abstract class minutely_user_activity_prtn_entry_clst_domainTableAccessor extends CassandraTable[minutely_user_activity_prtn_entry_clst_domainTableAccessor, minutely_user_activity_prtn_entry_clst_domainRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object domain extends StringColumn(this)with ClusteringOrder[String] with Ascending
object count extends LongColumn(this)


  override def tableName = "minutely_user_activity_prtn_entry_clst_domain"

  def fromRow(row: Row): minutely_user_activity_prtn_entry_clst_domainRow = {
    minutely_user_activity_prtn_entry_clst_domainRow(
      partner_id(row), 
entry_id(row), 
metric(row), 
minute(row), 
domain(row), 
count(row)
    )
  }

  def store(entity: minutely_user_activity_prtn_entry_clst_domainRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.entry_id, entity.entry_id)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.domain, entity.domain)
.value(_.count, entity.count)

      .future()
  }

  def query(partner_id : Int, entry_id : String, metric : Int) : SelectQuery[minutely_user_activity_prtn_entry_clst_domainTableAccessor, minutely_user_activity_prtn_entry_clst_domainRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.metric eqs metric)
  }
 def query(partner_id : Int, entry_id : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_prtn_entry_clst_domainTableAccessor, minutely_user_activity_prtn_entry_clst_domainRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partner_id : Int, entry_id : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime, domainStart : String, domainEnd : String) : SelectQuery[minutely_user_activity_prtn_entry_clst_domainTableAccessor, minutely_user_activity_prtn_entry_clst_domainRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.domain gte domainStart)
.and(_.domain lt domainEnd)
  }
def query(partner_id_list : List[Int], entry_id_list : List[String], metric_list : List[Int]) : SelectQuery[minutely_user_activity_prtn_entry_clst_domainTableAccessor, minutely_user_activity_prtn_entry_clst_domainRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], entry_id_list : List[String], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_user_activity_prtn_entry_clst_domainTableAccessor, minutely_user_activity_prtn_entry_clst_domainRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partner_id_list : List[Int], entry_id_list : List[String], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime, domainStart : String, domainEnd : String) : SelectQuery[minutely_user_activity_prtn_entry_clst_domainTableAccessor, minutely_user_activity_prtn_entry_clst_domainRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.domain gte domainStart)
.and(_.domain lt domainEnd)
  }

}