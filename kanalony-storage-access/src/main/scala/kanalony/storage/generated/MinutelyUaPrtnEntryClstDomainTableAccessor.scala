package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class MinutelyUaPrtnEntryClstDomainTableAccessor extends CassandraTable[MinutelyUaPrtnEntryClstDomainTableAccessor, MinutelyUaPrtnEntryClstDomainRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object domain extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "minutely_ua_prtn_entry_clst_domain"

  def fromRow(row: Row): MinutelyUaPrtnEntryClstDomainRow = {
    MinutelyUaPrtnEntryClstDomainRow(
      partner_id(row), 
entry_id(row), 
metric(row), 
minute(row), 
domain(row), 
value(row)
    )
  }

  def store(entity: MinutelyUaPrtnEntryClstDomainRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.entry_id, entity.entryId)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.domain, entity.domain)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, entryId : String, metric : Int) : SelectQuery[MinutelyUaPrtnEntryClstDomainTableAccessor, MinutelyUaPrtnEntryClstDomainRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.metric eqs metric)
  }
 def query(partnerId : Int, entryId : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[MinutelyUaPrtnEntryClstDomainTableAccessor, MinutelyUaPrtnEntryClstDomainRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partnerId : Int, entryId : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime, domainStart : String, domainEnd : String) : SelectQuery[MinutelyUaPrtnEntryClstDomainTableAccessor, MinutelyUaPrtnEntryClstDomainRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.domain gte domainStart)
.and(_.domain lt domainEnd)
  }
def query(partnerIdList : List[Int], entryIdList : List[String], metricList : List[Int]) : SelectQuery[MinutelyUaPrtnEntryClstDomainTableAccessor, MinutelyUaPrtnEntryClstDomainRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.metric in metricList)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], metricList : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[MinutelyUaPrtnEntryClstDomainTableAccessor, MinutelyUaPrtnEntryClstDomainRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.metric in metricList)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], metricList : List[Int], minuteStart : DateTime, minuteEnd : DateTime, domainStart : String, domainEnd : String) : SelectQuery[MinutelyUaPrtnEntryClstDomainTableAccessor, MinutelyUaPrtnEntryClstDomainRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.metric in metricList)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.domain gte domainStart)
.and(_.domain lt domainEnd)
  }

}