package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyAggClstBrowserTableAccessor extends CassandraTable[HourlyAggClstBrowserTableAccessor, HourlyAggClstBrowserRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object metric extends StringColumn(this)with PartitionKey[String]
object year extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object browser extends IntColumn(this)with ClusteringOrder[Int] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_agg_clst_browser"

  def fromRow(row: Row): HourlyAggClstBrowserRow = {
    HourlyAggClstBrowserRow(
      partner_id(row), 
metric(row), 
year(row), 
hour(row), 
browser(row), 
value(row)
    )
  }

  def store(entity: HourlyAggClstBrowserRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.metric, entity.metric)
.value(_.year, entity.year)
.value(_.hour, entity.hour)
.value(_.browser, entity.browser)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, metric : String, year : Int) : SelectQuery[HourlyAggClstBrowserTableAccessor, HourlyAggClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.year eqs year)
  }
 def query(partnerId : Int, metric : String, year : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyAggClstBrowserTableAccessor, HourlyAggClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerId : Int, metric : String, year : Int, hourStart : DateTime, hourEnd : DateTime, browserStart : Int, browserEnd : Int) : SelectQuery[HourlyAggClstBrowserTableAccessor, HourlyAggClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.browser gte browserStart)
.and(_.browser lt browserEnd)
  }
def query(partnerIdList : List[Int], metricList : List[String], yearList : List[Int]) : SelectQuery[HourlyAggClstBrowserTableAccessor, HourlyAggClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.year in yearList)
  }
 def query(partnerIdList : List[Int], metricList : List[String], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyAggClstBrowserTableAccessor, HourlyAggClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.year in yearList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerIdList : List[Int], metricList : List[String], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime, browserStart : Int, browserEnd : Int) : SelectQuery[HourlyAggClstBrowserTableAccessor, HourlyAggClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.year in yearList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.browser gte browserStart)
.and(_.browser lt browserEnd)
  }

}