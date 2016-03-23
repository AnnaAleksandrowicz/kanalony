package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyUaPrtnDeviceOsClstEntryTableAccessor extends CassandraTable[HourlyUaPrtnDeviceOsClstEntryTableAccessor, HourlyUaPrtnDeviceOsClstEntryRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object device extends IntColumn(this)with PartitionKey[Int]
object operating_system extends IntColumn(this)with PartitionKey[Int]
object year extends IntColumn(this)with PartitionKey[Int]
object metric extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object entry_id extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_ua_prtn_device_os_clst_entry"

  def fromRow(row: Row): HourlyUaPrtnDeviceOsClstEntryRow = {
    HourlyUaPrtnDeviceOsClstEntryRow(
      partner_id(row), 
device(row), 
operating_system(row), 
year(row), 
metric(row), 
hour(row), 
entry_id(row), 
value(row)
    )
  }

  def store(entity: HourlyUaPrtnDeviceOsClstEntryRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.device, entity.device)
.value(_.operating_system, entity.operatingSystem)
.value(_.year, entity.year)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.entry_id, entity.entryId)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, device : Int, operatingSystem : Int, year : Int, metric : Int) : SelectQuery[HourlyUaPrtnDeviceOsClstEntryTableAccessor, HourlyUaPrtnDeviceOsClstEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.device eqs device)
.and(_.operating_system eqs operatingSystem)
.and(_.year eqs year)
.and(_.metric eqs metric)
  }
 def query(partnerId : Int, device : Int, operatingSystem : Int, year : Int, metric : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaPrtnDeviceOsClstEntryTableAccessor, HourlyUaPrtnDeviceOsClstEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.device eqs device)
.and(_.operating_system eqs operatingSystem)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerId : Int, device : Int, operatingSystem : Int, year : Int, metric : Int, hourStart : DateTime, hourEnd : DateTime, entryIdStart : String, entryIdEnd : String) : SelectQuery[HourlyUaPrtnDeviceOsClstEntryTableAccessor, HourlyUaPrtnDeviceOsClstEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.device eqs device)
.and(_.operating_system eqs operatingSystem)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.entry_id gte entryIdStart)
.and(_.entry_id lt entryIdEnd)
  }
def query(partnerIdList : List[Int], deviceList : List[Int], operatingSystemList : List[Int], yearList : List[Int], metricList : List[Int]) : SelectQuery[HourlyUaPrtnDeviceOsClstEntryTableAccessor, HourlyUaPrtnDeviceOsClstEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.device in deviceList)
.and(_.operating_system in operatingSystemList)
.and(_.year in yearList)
.and(_.metric in metricList)
  }
 def query(partnerIdList : List[Int], deviceList : List[Int], operatingSystemList : List[Int], yearList : List[Int], metricList : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaPrtnDeviceOsClstEntryTableAccessor, HourlyUaPrtnDeviceOsClstEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.device in deviceList)
.and(_.operating_system in operatingSystemList)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerIdList : List[Int], deviceList : List[Int], operatingSystemList : List[Int], yearList : List[Int], metricList : List[Int], hourStart : DateTime, hourEnd : DateTime, entryIdStart : String, entryIdEnd : String) : SelectQuery[HourlyUaPrtnDeviceOsClstEntryTableAccessor, HourlyUaPrtnDeviceOsClstEntryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.device in deviceList)
.and(_.operating_system in operatingSystemList)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.entry_id gte entryIdStart)
.and(_.entry_id lt entryIdEnd)
  }

}