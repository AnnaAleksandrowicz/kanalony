package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class minutely_ua_prtn_cv1TableAccessor extends CassandraTable[minutely_ua_prtn_cv1TableAccessor, minutely_ua_prtn_cv1Row] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object custom_var1 extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "minutely_ua_prtn_cv1"

  def fromRow(row: Row): minutely_ua_prtn_cv1Row = {
    minutely_ua_prtn_cv1Row(
      partner_id(row), 
custom_var1(row), 
metric(row), 
minute(row), 
value(row)
    )
  }

  def store(entity: minutely_ua_prtn_cv1Row): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.custom_var1, entity.custom_var1)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.value, entity.value)

      .future()
  }

  def query(partner_id : Int, custom_var1 : String, metric : Int) : SelectQuery[minutely_ua_prtn_cv1TableAccessor, minutely_ua_prtn_cv1Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.custom_var1 eqs custom_var1)
.and(_.metric eqs metric)
  }
 def query(partner_id : Int, custom_var1 : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_prtn_cv1TableAccessor, minutely_ua_prtn_cv1Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partner_id).and(_.custom_var1 eqs custom_var1)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
def query(partner_id_list : List[Int], custom_var1_list : List[String], metric_list : List[Int]) : SelectQuery[minutely_ua_prtn_cv1TableAccessor, minutely_ua_prtn_cv1Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.custom_var1 in custom_var1_list)
.and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], custom_var1_list : List[String], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_prtn_cv1TableAccessor, minutely_ua_prtn_cv1Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partner_id_list).and(_.custom_var1 in custom_var1_list)
.and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }

}