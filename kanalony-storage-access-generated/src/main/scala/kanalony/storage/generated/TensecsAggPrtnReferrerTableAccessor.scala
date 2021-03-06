package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class TensecsAggPrtnReferrerTableAccessor extends CassandraTable[TensecsAggPrtnReferrerTableAccessor, TensecsAggPrtnReferrerRow] with RootConnector with ITensecsAggPrtnReferrerTableAccessor {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object referrer extends StringColumn(this)with PartitionKey[String]
object metric extends StringColumn(this)with PartitionKey[String]
object day extends IntColumn(this)with PartitionKey[Int]
object tensecs extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "tensecs_agg_prtn_referrer"

  def fromRow(row: Row): TensecsAggPrtnReferrerRow = {
    TensecsAggPrtnReferrerRow(
      partner_id(row), 
referrer(row), 
metric(row), 
day(row), 
tensecs(row), 
value(row)
    )
  }

  def store(entity: TensecsAggPrtnReferrerRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.referrer, entity.referrer)
.value(_.metric, entity.metric)
.value(_.day, entity.day)
.value(_.tensecs, entity.tensecs)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, referrer : String, metric : String, day : Int) : Future[List[TensecsAggPrtnReferrerRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.referrer eqs referrer)
.and(_.metric eqs metric)
.and(_.day eqs day)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, referrer : String, metric : String, day : Int, tensecsStart : DateTime, tensecsEnd : DateTime) : Future[List[TensecsAggPrtnReferrerRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.referrer eqs referrer)
.and(_.metric eqs metric)
.and(_.day eqs day)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
def query(partnerIdList : List[Int], referrerList : List[String], metricList : List[String], dayList : List[Int]) : Future[List[TensecsAggPrtnReferrerRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.referrer in referrerList)
.and(_.metric in metricList)
.and(_.day in dayList)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], referrerList : List[String], metricList : List[String], dayList : List[Int], tensecsStart : DateTime, tensecsEnd : DateTime) : Future[List[TensecsAggPrtnReferrerRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.referrer in referrerList)
.and(_.metric in metricList)
.and(_.day in dayList)
.and(_.tensecs gte tensecsStart)
.and(_.tensecs lt tensecsEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }

}

import org.joda.time.DateTime
case class TensecsAggPrtnReferrerRow(partnerId:Int,
referrer:String,
metric:String,
day:Int,
tensecs:DateTime,
value:Long)


import scala.concurrent.Future

trait ITensecsAggPrtnReferrerTableAccessor {
  def query(partnerId : Int, referrer : String, metric : String, day : Int) : Future[List[TensecsAggPrtnReferrerRow]]
 def query(partnerId : Int, referrer : String, metric : String, day : Int, tensecsStart : DateTime, tensecsEnd : DateTime) : Future[List[TensecsAggPrtnReferrerRow]]
def query(partnerIdList : List[Int], referrerList : List[String], metricList : List[String], dayList : List[Int]) : Future[List[TensecsAggPrtnReferrerRow]]
 def query(partnerIdList : List[Int], referrerList : List[String], metricList : List[String], dayList : List[Int], tensecsStart : DateTime, tensecsEnd : DateTime) : Future[List[TensecsAggPrtnReferrerRow]]
}