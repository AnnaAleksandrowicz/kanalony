package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import scala.concurrent.Future

abstract class minutely_ua_prtn_country_cityTableAccessor extends CassandraTable[minutely_ua_prtn_country_cityTableAccessor, minutely_ua_prtn_country_cityRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object country extends StringColumn(this)with PartitionKey[String]
object city extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "minutely_ua_prtn_country_city"

  def fromRow(row: Row): minutely_ua_prtn_country_cityRow = {
    minutely_ua_prtn_country_cityRow(
      partner_id(row), 
country(row), 
city(row), 
metric(row), 
minute(row), 
value(row)
    )
  }

  def store(entity: minutely_ua_prtn_country_cityRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partner_id)
.value(_.country, entity.country)
.value(_.city, entity.city)
.value(_.metric, entity.metric)
.value(_.minute, entity.minute)
.value(_.value, entity.value)

      .future()
  }

  def query(partner_id : Int, country : String, city : String, metric : Int) : SelectQuery[minutely_ua_prtn_country_cityTableAccessor, minutely_ua_prtn_country_cityRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.country eqs country)
.and(_.city eqs city)
.and(_.metric eqs metric)
  }
 def query(partner_id : Int, country : String, city : String, metric : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_prtn_country_cityTableAccessor, minutely_ua_prtn_country_cityRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id eqs partner_id).and(_.country eqs country)
.and(_.city eqs city)
.and(_.metric eqs metric)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
def query(partner_id_list : List[Int], country_list : List[String], city_list : List[String], metric_list : List[Int]) : SelectQuery[minutely_ua_prtn_country_cityTableAccessor, minutely_ua_prtn_country_cityRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.country in country_list)
.and(_.city in city_list)
.and(_.metric in metric_list)
  }
 def query(partner_id_list : List[Int], country_list : List[String], city_list : List[String], metric_list : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[minutely_ua_prtn_country_cityTableAccessor, minutely_ua_prtn_country_cityRow, Unlimited, Unordered, Unspecified, Chainned] = {
    select.where(_.partner_id in partner_id_list).and(_.country in country_list)
.and(_.city in city_list)
.and(_.metric in metric_list)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }

}