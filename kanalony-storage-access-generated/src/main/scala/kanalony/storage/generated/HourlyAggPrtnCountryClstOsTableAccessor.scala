package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyAggPrtnCountryClstOsTableAccessor extends CassandraTable[HourlyAggPrtnCountryClstOsTableAccessor, HourlyAggPrtnCountryClstOsRow] with RootConnector with IHourlyAggPrtnCountryClstOsTableAccessor {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object country extends StringColumn(this)with PartitionKey[String]
object year extends IntColumn(this)with PartitionKey[Int]
object metric extends StringColumn(this)with PartitionKey[String]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object operating_system extends IntColumn(this)with ClusteringOrder[Int] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_agg_prtn_country_clst_os"

  def fromRow(row: Row): HourlyAggPrtnCountryClstOsRow = {
    HourlyAggPrtnCountryClstOsRow(
      partner_id(row), 
country(row), 
year(row), 
metric(row), 
hour(row), 
operating_system(row), 
value(row)
    )
  }

  def store(entity: HourlyAggPrtnCountryClstOsRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.country, entity.country)
.value(_.year, entity.year)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.operating_system, entity.operatingSystem)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, country : String, year : Int, metric : String) : Future[List[HourlyAggPrtnCountryClstOsRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.year eqs year)
.and(_.metric eqs metric)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, country : String, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggPrtnCountryClstOsRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, country : String, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime, operatingSystemStart : Int, operatingSystemEnd : Int) : Future[List[HourlyAggPrtnCountryClstOsRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.operating_system gte operatingSystemStart)
.and(_.operating_system lt operatingSystemEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[String]) : Future[List[HourlyAggPrtnCountryClstOsRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.year in yearList)
.and(_.metric in metricList)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggPrtnCountryClstOsRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime, operatingSystemStart : Int, operatingSystemEnd : Int) : Future[List[HourlyAggPrtnCountryClstOsRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.operating_system gte operatingSystemStart)
.and(_.operating_system lt operatingSystemEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }

}

import org.joda.time.DateTime
case class HourlyAggPrtnCountryClstOsRow(partnerId:Int,
country:String,
year:Int,
metric:String,
hour:DateTime,
operatingSystem:Int,
value:Long)


import scala.concurrent.Future

trait IHourlyAggPrtnCountryClstOsTableAccessor {
  def query(partnerId : Int, country : String, year : Int, metric : String) : Future[List[HourlyAggPrtnCountryClstOsRow]]
 def query(partnerId : Int, country : String, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggPrtnCountryClstOsRow]]
 def query(partnerId : Int, country : String, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime, operatingSystemStart : Int, operatingSystemEnd : Int) : Future[List[HourlyAggPrtnCountryClstOsRow]]
def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[String]) : Future[List[HourlyAggPrtnCountryClstOsRow]]
 def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime) : Future[List[HourlyAggPrtnCountryClstOsRow]]
 def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime, operatingSystemStart : Int, operatingSystemEnd : Int) : Future[List[HourlyAggPrtnCountryClstOsRow]]
}