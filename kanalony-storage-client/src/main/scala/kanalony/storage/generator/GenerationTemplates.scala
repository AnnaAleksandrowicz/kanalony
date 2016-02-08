package kanalony.storage.generator

/**
 * Created by elad.benedict on 2/7/2016.
 */
object GenerationTemplates {

  case object entityClassTemplate {
    var content = "import org.joda.time.DateTime\n"
    content = content + "case class %CLASSNAME%(%COLDEFS%)"
    val classNamePlaceholder = "%CLASSNAME%"
    val colDefsPlaceholder = "%COLDEFS%"
    val classNameSuffix = "Row"
  }

  case object packageTemplate {
    val content = "package kanalony.storage.generated"
  }

  case object valueDefinitionTemplate {
    val content = ".value(_.%PROPNAME%, entity.%PROPNAME%)"
    val propertyNamePlaceholder = "%PROPNAME%"
  }

  class columnDefinitionTemplate() extends IColumnDefinitionTemplate {
    def content = "object %PROPNAME% extends %TYPE%Column(this)"
    def typePlaceholder = "%TYPE%"
    def propNamePlaceholder = "%PROPNAME%"
  }

  class partitionKeyColumnDefinitionTemplate() extends columnDefinitionTemplate {
    override def content = super.content + "with PartitionKey[" + super.typePlaceholder + "]"
  }

  class clusteringKeyColumnDefinitionTemplate(val orderBy : OrderBy.Value = OrderBy.Ascending) extends columnDefinitionTemplate {
    override def content = super.content + "with ClusteringOrder[" + super.typePlaceholder + "] with " + orderBy.toString
  }

  case object propertyDecompositionTemplate {
    val content = "%PROPNAME%(row)"
    val propNamePlaceholder = "%PROPNAME%"
  }

  case object tableAccessorTemplate {
    val classNamePlaceholder = "%CLASSNAME%"
    val entityClassNamePlaceholder = "%ENTITY_CLASS%"
    val valuePopulationPlaceholder = "%VALUE_POPULATION%"
    val rowDecompositionPlaceholder = "%ROW_DECOMPOSITION%"
    val tableColDefsPlaceholder = "%TABLE_COL_DEFS%"
    val tableNamePlaceholder = "%TABLE_NAME%"

    val content = """import com.websudos.phantom.dsl._
                    |import scala.concurrent.Future
                    |
                    |abstract class %CLASSNAME% extends CassandraTable[%CLASSNAME%, %ENTITY_CLASS%] with RootConnector {
                    |
                    |  %TABLE_COL_DEFS%
                    |
                    |  override def tableName = "%TABLE_NAME%"
                    |
                    |  def fromRow(row: Row): %ENTITY_CLASS% = {
                    |    %ENTITY_CLASS%(
                    |      %ROW_DECOMPOSITION%
                    |    )
                    |  }
                    |
                    |  def store(entity: %ENTITY_CLASS%): Future[ResultSet] = {
                    |    insert%VALUE_POPULATION%
                    |      //.consistencyLevel_=(ConsistencyLevel.Any)
                    |      .future()
                    |  }
                    |}"""
  }
}

trait IColumnDefinitionTemplate {
  def content : String
  def typePlaceholder : String
  def propNamePlaceholder : String
}
