package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyAggPrtnEntryCv3TableAccessor extends CassandraTable[HourlyAggPrtnEntryCv3TableAccessor, HourlyAggPrtnEntryCv3Row] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object custom_var3 extends StringColumn(this)with PartitionKey[String]
object year extends IntColumn(this)with PartitionKey[Int]
object metric extends StringColumn(this)with PartitionKey[String]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "hourly_agg_prtn_entry_cv3"

  def fromRow(row: Row): HourlyAggPrtnEntryCv3Row = {
    HourlyAggPrtnEntryCv3Row(
      partner_id(row), 
entry_id(row), 
custom_var3(row), 
year(row), 
metric(row), 
hour(row), 
value(row)
    )
  }

  def store(entity: HourlyAggPrtnEntryCv3Row): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.entry_id, entity.entryId)
.value(_.custom_var3, entity.customVar3)
.value(_.year, entity.year)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, entryId : String, customVar3 : String, year : Int, metric : String) : SelectQuery[HourlyAggPrtnEntryCv3TableAccessor, HourlyAggPrtnEntryCv3Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.custom_var3 eqs customVar3)
.and(_.year eqs year)
.and(_.metric eqs metric)
  }
 def query(partnerId : Int, entryId : String, customVar3 : String, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyAggPrtnEntryCv3TableAccessor, HourlyAggPrtnEntryCv3Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.custom_var3 eqs customVar3)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
def query(partnerIdList : List[Int], entryIdList : List[String], customVar3List : List[String], yearList : List[Int], metricList : List[String]) : SelectQuery[HourlyAggPrtnEntryCv3TableAccessor, HourlyAggPrtnEntryCv3Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.custom_var3 in customVar3List)
.and(_.year in yearList)
.and(_.metric in metricList)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], customVar3List : List[String], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyAggPrtnEntryCv3TableAccessor, HourlyAggPrtnEntryCv3Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.custom_var3 in customVar3List)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }

}