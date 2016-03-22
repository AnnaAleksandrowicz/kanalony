package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class hourly_ua_prtn_device_clst_entryTableAccessor extends CassandraTable[hourly_ua_prtn_device_clst_entryTableAccessor, hourly_ua_prtn_device_clst_entryRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object device extends IntColumn(this)with PartitionKey[Int]
object year extends IntColumn(this)with PartitionKey[Int]
object metric extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object entry_id extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_ua_prtn_device_clst_entry"

  def fromRow(row: Row): hourly_ua_prtn_device_clst_entryRow = {
    hourly_ua_prtn_device_clst_entryRow(
      partner_id(row), 
device(row), 
year(row), 
metric(row), 
hour(row), 
entry_id(row), 
value(row)
    )
  }

  def store(entity: hourly_ua_prtn_device_clst_entryRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.device, entity.device)
.value(_.year, entity.year)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.entry_id, entity.entry_id)
.value(_.value, entity.value)

      .future()
  }

  def query(partner_id : Int, device : Int, year : Int, metric : Int) : SelectQuery[hourly_ua_prtn_device_clst_entryTableAccessor, hourly_ua_prtn_device_clst_entryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.device eqs device)
.and(_.year eqs year)
.and(_.metric eqs metric)
  }
 def query(partner_id : Int, device : Int, year : Int, metric : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[hourly_ua_prtn_device_clst_entryTableAccessor, hourly_ua_prtn_device_clst_entryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.device eqs device)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partner_id : Int, device : Int, year : Int, metric : Int, hourStart : DateTime, hourEnd : DateTime, entry_idStart : String, entry_idEnd : String) : SelectQuery[hourly_ua_prtn_device_clst_entryTableAccessor, hourly_ua_prtn_device_clst_entryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.device eqs device)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.entry_id gte entry_idStart)
.and(_.entry_id lt entry_idEnd)
  }
def query(partner_id_list : List[Int], device_list : List[Int], year_list : List[Int], metric_list : List[Int]) : SelectQuery[hourly_ua_prtn_device_clst_entryTableAccessor, hourly_ua_prtn_device_clst_entryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.device in device_list)
.and(_.year in year_list)
.and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], device_list : List[Int], year_list : List[Int], metric_list : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[hourly_ua_prtn_device_clst_entryTableAccessor, hourly_ua_prtn_device_clst_entryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.device in device_list)
.and(_.year in year_list)
.and(_.metric in metric_list)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partner_id_list : List[Int], device_list : List[Int], year_list : List[Int], metric_list : List[Int], hourStart : DateTime, hourEnd : DateTime, entry_idStart : String, entry_idEnd : String) : SelectQuery[hourly_ua_prtn_device_clst_entryTableAccessor, hourly_ua_prtn_device_clst_entryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.device in device_list)
.and(_.year in year_list)
.and(_.metric in metric_list)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.entry_id gte entry_idStart)
.and(_.entry_id lt entry_idEnd)
  }

}