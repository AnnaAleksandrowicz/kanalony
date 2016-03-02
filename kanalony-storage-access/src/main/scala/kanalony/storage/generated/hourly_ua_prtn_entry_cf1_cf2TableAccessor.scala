package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class hourly_ua_prtn_entry_cf1_cf2TableAccessor extends CassandraTable[hourly_ua_prtn_entry_cf1_cf2TableAccessor, hourly_ua_prtn_entry_cf1_cf2Row] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object cf1 extends StringColumn(this)with PartitionKey[String]
object cf2 extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object year extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "hourly_ua_prtn_entry_cf1_cf2"

  def fromRow(row: Row): hourly_ua_prtn_entry_cf1_cf2Row = {
    hourly_ua_prtn_entry_cf1_cf2Row(
      partner_id(row), 
entry_id(row), 
cf1(row), 
cf2(row), 
metric(row), 
year(row), 
hour(row), 
value(row)
    )
  }

  def store(entity: hourly_ua_prtn_entry_cf1_cf2Row): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.entry_id, entity.entry_id)
.value(_.cf1, entity.cf1)
.value(_.cf2, entity.cf2)
.value(_.metric, entity.metric)
.value(_.year, entity.year)
.value(_.hour, entity.hour)
.value(_.value, entity.value)

      .future()
  }

  def query(partner_id : Int, entry_id : String, cf1 : String, cf2 : String, metric : Int, year : Int) : SelectQuery[hourly_ua_prtn_entry_cf1_cf2TableAccessor, hourly_ua_prtn_entry_cf1_cf2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.cf1 eqs cf1)
.and(_.cf2 eqs cf2)
.and(_.metric eqs metric)
.and(_.year eqs year)
  }
 def query(partner_id : Int, entry_id : String, cf1 : String, cf2 : String, metric : Int, year : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[hourly_ua_prtn_entry_cf1_cf2TableAccessor, hourly_ua_prtn_entry_cf1_cf2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.entry_id eqs entry_id)
.and(_.cf1 eqs cf1)
.and(_.cf2 eqs cf2)
.and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
def query(partner_id_list : List[Int], entry_id_list : List[String], cf1_list : List[String], cf2_list : List[String], metric_list : List[Int], year_list : List[Int]) : SelectQuery[hourly_ua_prtn_entry_cf1_cf2TableAccessor, hourly_ua_prtn_entry_cf1_cf2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.cf1 in cf1_list)
.and(_.cf2 in cf2_list)
.and(_.metric in metric_list)
.and(_.year in year_list)
  }
 def query(partner_id_list : List[Int], entry_id_list : List[String], cf1_list : List[String], cf2_list : List[String], metric_list : List[Int], year_list : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[hourly_ua_prtn_entry_cf1_cf2TableAccessor, hourly_ua_prtn_entry_cf1_cf2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.entry_id in entry_id_list)
.and(_.cf1 in cf1_list)
.and(_.cf2 in cf2_list)
.and(_.metric in metric_list)
.and(_.year in year_list)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }

}