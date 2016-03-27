package kanalony.storage.generator

import java.io.File

import kanalony.storage.utils.fs

/**
 * Created by elad.benedict on 3/27/2016.
 */
object CassandraCqlGenerator {

  def main (args: Array[String]) {

    val keySpaceName = "kanalony_user_activity"
    var res = List(s"CREATE KEYSPACE IF NOT EXISTS ${keySpaceName} WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;")

    val tableNamePlaceholder = "%TABLE_NAME%"
    val columnDefsPlaceholder = "%COLUMN_DEFS%"
    val partitionKeyColsPlaceholder = "%PARTITION_KEY_COLS%"
    val clusteringColsPlaceholder = "%CLUSTERING_KEY_COLS%"
    val timeColPlaceholder = "%TIME_COL%"

    val tableCreationTemplate = s"""CREATE TABLE IF NOT EXISTS ${keySpaceName}.%TABLE_NAME% (
                                  |    %COLUMN_DEFS%
                                  |    PRIMARY KEY ((%PARTITION_KEY_COLS%), %CLUSTERING_KEY_COLS%)
                                  |) WITH CLUSTERING ORDER BY (%TIME_COL% DESC);"""

    def getCassandraType(typeName: ColumnType.Value) : String = typeName match {
      case ColumnType.DateTime => "timestamp"
      case ColumnType.Int => "int"
      case ColumnType.Long => "bigint"
      case ColumnType.String => "text"
    }

    TablesMetadata.metadata.map(tm => {
        val tableScript = tableCreationTemplate
          .replace(tableNamePlaceholder, tm.tableName)
          .replace(columnDefsPlaceholder, tm.columns.map(c => s"${c.name} ${getCassandraType(c.typeName)}").mkString("", ",\n", ",\n"))
          .replace(partitionKeyColsPlaceholder, tm.primaryKey.pk.columns.map(_.name).mkString(","))
          .replace(clusteringColsPlaceholder, tm.primaryKey.ck.columns.map(_.name).mkString(","))
          .replace(timeColPlaceholder, tm.primaryKey.ck.columns.head.name.toString)
        res = res :+ tableScript
    })

    fs.printToFile(new File("kanalony_user_activity.cql"))(p=>(p.write(res.mkString("\n\n").stripMargin)))
  }
}
