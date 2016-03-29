package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyAggPrtnEntryTableAccessor extends CassandraTable[HourlyAggPrtnEntryTableAccessor, HourlyAggPrtnEntryRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object month extends IntColumn(this)with PartitionKey[Int]
object metric extends StringColumn(this)with PartitionKey[String]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "hourly_agg_prtn_entry"

  def fromRow(row: Row): HourlyAggPrtnEntryRow = {
    HourlyAggPrtnEntryRow(
      partner_id(row), 
entry_id(row), 
month(row), 
metric(row), 
hour(row), 
value(row)
    )
  }

  def store(entity: HourlyAggPrtnEntryRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.entry_id, entity.entryId)
.value(_.month, entity.month)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, entryId : String, month : Int, metric : String) : SelectQuery[HourlyAggPrtnEntryTableAccessor, HourlyAggPrtnEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.month eqs month)
.and(_.metric eqs metric)
  }
 def query(partnerId : Int, entryId : String, month : Int, metric : String, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyAggPrtnEntryTableAccessor, HourlyAggPrtnEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.month eqs month)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
def query(partnerIdList : List[Int], entryIdList : List[String], monthList : List[Int], metricList : List[String]) : SelectQuery[HourlyAggPrtnEntryTableAccessor, HourlyAggPrtnEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.month in monthList)
.and(_.metric in metricList)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], monthList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyAggPrtnEntryTableAccessor, HourlyAggPrtnEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.month in monthList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }

}