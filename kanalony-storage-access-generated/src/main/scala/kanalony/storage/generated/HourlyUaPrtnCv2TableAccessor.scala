package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyUaPrtnCv2TableAccessor extends CassandraTable[HourlyUaPrtnCv2TableAccessor, HourlyUaPrtnCv2Row] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object custom_var2 extends StringColumn(this)with PartitionKey[String]
object year extends IntColumn(this)with PartitionKey[Int]
object metric extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "hourly_ua_prtn_cv2"

  def fromRow(row: Row): HourlyUaPrtnCv2Row = {
    HourlyUaPrtnCv2Row(
      partner_id(row), 
custom_var2(row), 
year(row), 
metric(row), 
hour(row), 
value(row)
    )
  }

  def store(entity: HourlyUaPrtnCv2Row): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.custom_var2, entity.customVar2)
.value(_.year, entity.year)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, customVar2 : String, year : Int, metric : Int) : SelectQuery[HourlyUaPrtnCv2TableAccessor, HourlyUaPrtnCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.custom_var2 eqs customVar2)
.and(_.year eqs year)
.and(_.metric eqs metric)
  }
 def query(partnerId : Int, customVar2 : String, year : Int, metric : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaPrtnCv2TableAccessor, HourlyUaPrtnCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.custom_var2 eqs customVar2)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
def query(partnerIdList : List[Int], customVar2List : List[String], yearList : List[Int], metricList : List[Int]) : SelectQuery[HourlyUaPrtnCv2TableAccessor, HourlyUaPrtnCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.custom_var2 in customVar2List)
.and(_.year in yearList)
.and(_.metric in metricList)
  }
 def query(partnerIdList : List[Int], customVar2List : List[String], yearList : List[Int], metricList : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaPrtnCv2TableAccessor, HourlyUaPrtnCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.custom_var2 in customVar2List)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }

}