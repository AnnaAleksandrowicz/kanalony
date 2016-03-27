package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyUaPrtnCountryClstBrowserTableAccessor extends CassandraTable[HourlyUaPrtnCountryClstBrowserTableAccessor, HourlyUaPrtnCountryClstBrowserRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object country extends StringColumn(this)with PartitionKey[String]
object year extends IntColumn(this)with PartitionKey[Int]
object metric extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object browser extends IntColumn(this)with ClusteringOrder[Int] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_ua_prtn_country_clst_browser"

  def fromRow(row: Row): HourlyUaPrtnCountryClstBrowserRow = {
    HourlyUaPrtnCountryClstBrowserRow(
      partner_id(row), 
country(row), 
year(row), 
metric(row), 
hour(row), 
browser(row), 
value(row)
    )
  }

  def store(entity: HourlyUaPrtnCountryClstBrowserRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.country, entity.country)
.value(_.year, entity.year)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.browser, entity.browser)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, country : String, year : Int, metric : Int) : SelectQuery[HourlyUaPrtnCountryClstBrowserTableAccessor, HourlyUaPrtnCountryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.year eqs year)
.and(_.metric eqs metric)
  }
 def query(partnerId : Int, country : String, year : Int, metric : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaPrtnCountryClstBrowserTableAccessor, HourlyUaPrtnCountryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerId : Int, country : String, year : Int, metric : Int, hourStart : DateTime, hourEnd : DateTime, browserStart : Int, browserEnd : Int) : SelectQuery[HourlyUaPrtnCountryClstBrowserTableAccessor, HourlyUaPrtnCountryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.country eqs country)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.browser gte browserStart)
.and(_.browser lt browserEnd)
  }
def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[Int]) : SelectQuery[HourlyUaPrtnCountryClstBrowserTableAccessor, HourlyUaPrtnCountryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.year in yearList)
.and(_.metric in metricList)
  }
 def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaPrtnCountryClstBrowserTableAccessor, HourlyUaPrtnCountryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerIdList : List[Int], countryList : List[String], yearList : List[Int], metricList : List[Int], hourStart : DateTime, hourEnd : DateTime, browserStart : Int, browserEnd : Int) : SelectQuery[HourlyUaPrtnCountryClstBrowserTableAccessor, HourlyUaPrtnCountryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.country in countryList)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.browser gte browserStart)
.and(_.browser lt browserEnd)
  }

}