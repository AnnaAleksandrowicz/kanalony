package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyUaPrtnPlaybackContextTableAccessor extends CassandraTable[HourlyUaPrtnPlaybackContextTableAccessor, HourlyUaPrtnPlaybackContextRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object playback_context extends StringColumn(this)with PartitionKey[String]
object metric extends IntColumn(this)with PartitionKey[Int]
object year extends IntColumn(this)with PartitionKey[Int]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "hourly_ua_prtn_playback_context"

  def fromRow(row: Row): HourlyUaPrtnPlaybackContextRow = {
    HourlyUaPrtnPlaybackContextRow(
      partner_id(row), 
playback_context(row), 
metric(row), 
year(row), 
hour(row), 
value(row)
    )
  }

  def store(entity: HourlyUaPrtnPlaybackContextRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.playback_context, entity.playbackContext)
.value(_.metric, entity.metric)
.value(_.year, entity.year)
.value(_.hour, entity.hour)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, playbackContext : String, metric : Int, year : Int) : SelectQuery[HourlyUaPrtnPlaybackContextTableAccessor, HourlyUaPrtnPlaybackContextRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.playback_context eqs playbackContext)
.and(_.metric eqs metric)
.and(_.year eqs year)
  }
 def query(partnerId : Int, playbackContext : String, metric : Int, year : Int, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaPrtnPlaybackContextTableAccessor, HourlyUaPrtnPlaybackContextRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.playback_context eqs playbackContext)
.and(_.metric eqs metric)
.and(_.year eqs year)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
def query(partnerIdList : List[Int], playbackContextList : List[String], metricList : List[Int], yearList : List[Int]) : SelectQuery[HourlyUaPrtnPlaybackContextTableAccessor, HourlyUaPrtnPlaybackContextRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.playback_context in playbackContextList)
.and(_.metric in metricList)
.and(_.year in yearList)
  }
 def query(partnerIdList : List[Int], playbackContextList : List[String], metricList : List[Int], yearList : List[Int], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyUaPrtnPlaybackContextTableAccessor, HourlyUaPrtnPlaybackContextRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.playback_context in playbackContextList)
.and(_.metric in metricList)
.and(_.year in yearList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }

}