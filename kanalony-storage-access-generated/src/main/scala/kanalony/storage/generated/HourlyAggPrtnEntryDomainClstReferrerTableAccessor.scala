package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyAggPrtnEntryDomainClstReferrerTableAccessor extends CassandraTable[HourlyAggPrtnEntryDomainClstReferrerTableAccessor, HourlyAggPrtnEntryDomainClstReferrerRow] with RootConnector with IHourlyAggPrtnEntryDomainClstReferrerTableAccessor {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object domain extends StringColumn(this)with PartitionKey[String]
object metric extends StringColumn(this)with PartitionKey[String]
object year extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object referrer extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_agg_prtn_entry_domain_clst_referrer"

  def fromRow(row: Row): HourlyAggPrtnEntryDomainClstReferrerRow = {
    HourlyAggPrtnEntryDomainClstReferrerRow(
      partner_id(row), 
entry_id(row), 
domain(row), 
metric(row), 
year(row), 
hour(row), 
referrer(row), 
value(row)
    )
  }

  def store(entity: HourlyAggPrtnEntryDomainClstReferrerRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.entry_id, entity.entryId)
.value(_.domain, entity.domain)
.value(_.metric, entity.metric)
.value(_.year, entity.year)
.value(_.hour, entity.hour)
.value(_.referrer, entity.referrer)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, entryId : String, domain : String, metric : String, year : Int) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.domain eqs domain)
.and(_.metric eqs metric)
.and(_.year eqs year)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, entryId : String, domain : String, metric : String, year : Int, hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.domain eqs domain)
.and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, entryId : String, domain : String, metric : String, year : Int, hourStart : DateTime, hourEnd : DateTime, referrerStart : String, referrerEnd : String) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.domain eqs domain)
.and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.referrer gte referrerStart)
.and(_.referrer lt referrerEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
def query(partnerIdList : List[Int], entryIdList : List[String], domainList : List[String], metricList : List[String], yearList : List[Int]) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.domain in domainList)
.and(_.metric in metricList)
.and(_.year in yearList)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], domainList : List[String], metricList : List[String], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.domain in domainList)
.and(_.metric in metricList)
.and(_.year in yearList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], domainList : List[String], metricList : List[String], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime, referrerStart : String, referrerEnd : String) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.domain in domainList)
.and(_.metric in metricList)
.and(_.year in yearList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.referrer gte referrerStart)
.and(_.referrer lt referrerEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }

}

import org.joda.time.DateTime
case class HourlyAggPrtnEntryDomainClstReferrerRow(partnerId:Int,
entryId:String,
domain:String,
metric:String,
year:Int,
hour:DateTime,
referrer:String,
value:Long)


import scala.concurrent.Future

trait IHourlyAggPrtnEntryDomainClstReferrerTableAccessor {
  def query(partnerId : Int, entryId : String, domain : String, metric : String, year : Int) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]]
 def query(partnerId : Int, entryId : String, domain : String, metric : String, year : Int, hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]]
 def query(partnerId : Int, entryId : String, domain : String, metric : String, year : Int, hourStart : DateTime, hourEnd : DateTime, referrerStart : String, referrerEnd : String) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]]
def query(partnerIdList : List[Int], entryIdList : List[String], domainList : List[String], metricList : List[String], yearList : List[Int]) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]]
 def query(partnerIdList : List[Int], entryIdList : List[String], domainList : List[String], metricList : List[String], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]]
 def query(partnerIdList : List[Int], entryIdList : List[String], domainList : List[String], metricList : List[String], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime, referrerStart : String, referrerEnd : String) : Future[List[HourlyAggPrtnEntryDomainClstReferrerRow]]
}