package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class minutely_ua_clst_deviceTableAccessor extends CassandraTable[minutely_ua_clst_deviceTableAccessor, minutely_ua_clst_deviceRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object device extends IntColumn(this)with ClusteringOrder[Int] with Ascending
object value extends LongColumn(this)


  override def tableName = "minutely_ua_clst_device"

  def fromRow(row: Row): minutely_ua_clst_deviceRow = {
    minutely_ua_clst_deviceRow(
      partner_id(row), 
metric(row), 
minute(row), 
device(row), 
value(row)
    )
  }

  def store(entity: minutely_ua_clst_deviceRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.device, entity.device)
.value(_.value, entity.value)

      .future()
  }

  def query(partner_id : Int, metric : Int) : SelectQuery[minutely_ua_clst_deviceTableAccessor, minutely_ua_clst_deviceRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
  }
 def query(partner_id : Int, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_clst_deviceTableAccessor, minutely_ua_clst_deviceRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partner_id : Int, metric : Int, minuteStart : DateTime, minuteEnd : DateTime, deviceStart : Int, deviceEnd : Int) : SelectQuery[minutely_ua_clst_deviceTableAccessor, minutely_ua_clst_deviceRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.device gte deviceStart)
.and(_.device lt deviceEnd)
  }
def query(partner_id_list : List[Int], metric_list : List[Int]) : SelectQuery[minutely_ua_clst_deviceTableAccessor, minutely_ua_clst_deviceRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_clst_deviceTableAccessor, minutely_ua_clst_deviceRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partner_id_list : List[Int], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime, deviceStart : Int, deviceEnd : Int) : SelectQuery[minutely_ua_clst_deviceTableAccessor, minutely_ua_clst_deviceRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.device gte deviceStart)
.and(_.device lt deviceEnd)
  }

}