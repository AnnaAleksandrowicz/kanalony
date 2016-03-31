package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class TensecsAggPrtnEntryReferrerTableAccessor extends CassandraTable[TensecsAggPrtnEntryReferrerTableAccessor, TensecsAggPrtnEntryReferrerRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object referrer extends StringColumn(this)with PartitionKey[String]
object metric extends StringColumn(this)with PartitionKey[String]
object day extends IntColumn(this)with PartitionKey[Int]
object tensecs extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "tensecs_agg_prtn_entry_referrer"

  def fromRow(row: Row): TensecsAggPrtnEntryReferrerRow = {
    TensecsAggPrtnEntryReferrerRow(
      partner_id(row), 
entry_id(row), 
referrer(row), 
metric(row), 
day(row), 
tensecs(row), 
value(row)
    )
  }

  def store(entity: TensecsAggPrtnEntryReferrerRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.entry_id, entity.entryId)
.value(_.referrer, entity.referrer)
.value(_.metric, entity.metric)
.value(_.day, entity.day)
.value(_.tensecs, entity.tensecs)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, entryId : String, referrer : String, metric : String, day : Int) : SelectQuery[TensecsAggPrtnEntryReferrerTableAccessor, TensecsAggPrtnEntryReferrerRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.referrer eqs referrer)
.and(_.metric eqs metric)
.and(_.day eqs day)
  }
 def query(partnerId : Int, entryId : String, referrer : String, metric : String, day : Int, tensecsStart : DateTime, tensecsEnd : DateTime) : SelectQuery[TensecsAggPrtnEntryReferrerTableAccessor, TensecsAggPrtnEntryReferrerRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.referrer eqs referrer)
.and(_.metric eqs metric)
.and(_.day eqs day)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
  }
def query(partnerIdList : List[Int], entryIdList : List[String], referrerList : List[String], metricList : List[String], dayList : List[Int]) : SelectQuery[TensecsAggPrtnEntryReferrerTableAccessor, TensecsAggPrtnEntryReferrerRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.referrer in referrerList)
.and(_.metric in metricList)
.and(_.day in dayList)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], referrerList : List[String], metricList : List[String], dayList : List[Int], tensecsStart : DateTime, tensecsEnd : DateTime) : SelectQuery[TensecsAggPrtnEntryReferrerTableAccessor, TensecsAggPrtnEntryReferrerRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.referrer in referrerList)
.and(_.metric in metricList)
.and(_.day in dayList)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
  }

}