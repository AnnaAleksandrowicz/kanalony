package com.kaltura.model.dao

import com.kaltura.client.types.KalturaCategoryEntryFilter
import com.kaltura.model.entities.Entry

import scala.collection.JavaConversions._

/**
 * Created by ofirk on 27/01/2016.
 */
object EntryDAO extends DAOBase[Entry, String] {
  def getById(partnerId: Int, entryId:String): Option[Entry] = {
    withPartnerImpersonation(partnerId) { () =>
      try {
        val categoriesSet = getEntryCategories(entryId)
        Some(Entry(entryId, Some(categoriesSet.mkString(","))))
      }
      catch {
        case e: Exception => println(s"Error while fetching Entry data ($partnerId,$entryId):");e.printStackTrace();None
      }
    }
  }

  def getEntryCategories(entryId: String): Set[String] = {
    val categoriesSet = scala.collection.mutable.Set[String]()
    val categoryEntryFilter = new KalturaCategoryEntryFilter()
    categoryEntryFilter.entryIdEqual = entryId
    val kCategories = kalturaAPI.getCategoryEntryService.list(categoryEntryFilter)
    kCategories.objects.foreach { kce => categoriesSet ++= kce.categoryFullIds.split(">") }
    categoriesSet.toSet
  }

}