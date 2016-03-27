package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyUaClstCategoryTableAccessor extends CassandraTable[HourlyUaClstCategoryTableAccessor, HourlyUaClstCategoryRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object metric extends IntColumn(this)with PartitionKey[Int]
object year extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object category extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_ua_clst_category"

  def fromRow(row: Row): HourlyUaClstCategoryRow = {
    HourlyUaClstCategoryRow(
      partner_id(row), 
metric(row), 
year(row), 
hour(row), 
category(row), 
value(row)
    )
  }

  def store(entity: HourlyUaClstCategoryRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.metric, entity.metric)
.value(_.year, entity.year)
.value(_.hour, entity.hour)
.value(_.category, entity.category)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, metric : Int, year : Int) : SelectQuery[HourlyUaClstCategoryTableAccessor, HourlyUaClstCategoryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.year eqs year)
  }
 def query(partnerId : Int, metric : Int, year : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaClstCategoryTableAccessor, HourlyUaClstCategoryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerId : Int, metric : Int, year : Int, hourStart : DateTime, hourEnd : DateTime, categoryStart : String, categoryEnd : String) : SelectQuery[HourlyUaClstCategoryTableAccessor, HourlyUaClstCategoryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.category gte categoryStart)
.and(_.category lt categoryEnd)
  }
def query(partnerIdList : List[Int], metricList : List[Int], yearList : List[Int]) : SelectQuery[HourlyUaClstCategoryTableAccessor, HourlyUaClstCategoryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.year in yearList)
  }
 def query(partnerIdList : List[Int], metricList : List[Int], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaClstCategoryTableAccessor, HourlyUaClstCategoryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.year in yearList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerIdList : List[Int], metricList : List[Int], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime, categoryStart : String, categoryEnd : String) : SelectQuery[HourlyUaClstCategoryTableAccessor, HourlyUaClstCategoryRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.year in yearList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.category gte categoryStart)
.and(_.category lt categoryEnd)
  }

}