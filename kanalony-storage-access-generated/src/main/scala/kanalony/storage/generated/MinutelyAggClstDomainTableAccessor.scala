package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class MinutelyAggClstDomainTableAccessor extends CassandraTable[MinutelyAggClstDomainTableAccessor, MinutelyAggClstDomainRow] with RootConnector with IMinutelyAggClstDomainTableAccessor {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object metric extends StringColumn(this)with PartitionKey[String]
object day extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object domain extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "minutely_agg_clst_domain"

  def fromRow(row: Row): MinutelyAggClstDomainRow = {
    MinutelyAggClstDomainRow(
      partner_id(row), 
metric(row), 
day(row), 
minute(row), 
domain(row), 
value(row)
    )
  }

  def store(entity: MinutelyAggClstDomainRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.metric, entity.metric)
.value(_.day, entity.day)
.value(_.minute, entity.minute)
.value(_.domain, entity.domain)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, metric : String, day : Int) : Future[List[MinutelyAggClstDomainRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.day eqs day)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, metric : String, day : Int, minuteStart : DateTime, minuteEnd : DateTime) : Future[List[MinutelyAggClstDomainRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.day eqs day)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerId : Int, metric : String, day : Int, minuteStart : DateTime, minuteEnd : DateTime, domainStart : String, domainEnd : String) : Future[List[MinutelyAggClstDomainRow]] = {
    select.where(_.partner_id eqs partnerId).and(_.metric eqs metric)
.and(_.day eqs day)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.domain gte domainStart)
.and(_.domain lt domainEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
def query(partnerIdList : List[Int], metricList : List[String], dayList : List[Int]) : Future[List[MinutelyAggClstDomainRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.day in dayList)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], metricList : List[String], dayList : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : Future[List[MinutelyAggClstDomainRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.day in dayList)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }
 def query(partnerIdList : List[Int], metricList : List[String], dayList : List[Int], minuteStart : DateTime, minuteEnd : DateTime, domainStart : String, domainEnd : String) : Future[List[MinutelyAggClstDomainRow]] = {
    select.where(_.partner_id in partnerIdList).and(_.metric in metricList)
.and(_.day in dayList)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.domain gte domainStart)
.and(_.domain lt domainEnd)
    .fetch()(session, scala.concurrent.ExecutionContext.Implicits.global, space)
  }

}

import org.joda.time.DateTime
case class MinutelyAggClstDomainRow(partnerId:Int,
metric:String,
day:Int,
minute:DateTime,
domain:String,
value:Long)


import scala.concurrent.Future

trait IMinutelyAggClstDomainTableAccessor {
  def query(partnerId : Int, metric : String, day : Int) : Future[List[MinutelyAggClstDomainRow]]
 def query(partnerId : Int, metric : String, day : Int, minuteStart : DateTime, minuteEnd : DateTime) : Future[List[MinutelyAggClstDomainRow]]
 def query(partnerId : Int, metric : String, day : Int, minuteStart : DateTime, minuteEnd : DateTime, domainStart : String, domainEnd : String) : Future[List[MinutelyAggClstDomainRow]]
def query(partnerIdList : List[Int], metricList : List[String], dayList : List[Int]) : Future[List[MinutelyAggClstDomainRow]]
 def query(partnerIdList : List[Int], metricList : List[String], dayList : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : Future[List[MinutelyAggClstDomainRow]]
 def query(partnerIdList : List[Int], metricList : List[String], dayList : List[Int], minuteStart : DateTime, minuteEnd : DateTime, domainStart : String, domainEnd : String) : Future[List[MinutelyAggClstDomainRow]]
}