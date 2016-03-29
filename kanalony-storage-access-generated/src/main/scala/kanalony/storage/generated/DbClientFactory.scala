package kanalony.storage

import kanalony.storage._
import com.websudos.phantom.connectors.KeySpace
import kanalony.storage.generated._

object DbClientFactory {

  val connector = ConnectorFactory.connector

  val session = connector.session
  val keyspace = KeySpace(connector.name)

  object MinutelyUaPrtnCv1ClstCv2TableAccessor extends MinutelyUaPrtnCv1ClstCv2TableAccessor with connector.Connector
object TensecsUaClstAppTableAccessor extends TensecsUaClstAppTableAccessor with connector.Connector
object HourlyUaPrtnCountryCityTableAccessor extends HourlyUaPrtnCountryCityTableAccessor with connector.Connector
object MinutelyUaClstCountryCityTableAccessor extends MinutelyUaClstCountryCityTableAccessor with connector.Connector
object HourlyUaPrtnEntryTableAccessor extends HourlyUaPrtnEntryTableAccessor with connector.Connector
object TensecsUaPrtnCountryOsClstBrowserTableAccessor extends TensecsUaPrtnCountryOsClstBrowserTableAccessor with connector.Connector
object HourlyUaPrtnDomainClstReferrerTableAccessor extends HourlyUaPrtnDomainClstReferrerTableAccessor with connector.Connector
object MinutelyUaPrtnDomainTableAccessor extends MinutelyUaPrtnDomainTableAccessor with connector.Connector
object TensecsUaPrtnOsTableAccessor extends TensecsUaPrtnOsTableAccessor with connector.Connector
object MinutelyUaPrtnAppClstPlaybackContextTableAccessor extends MinutelyUaPrtnAppClstPlaybackContextTableAccessor with connector.Connector
object HourlyUaPrtnAppClstPlaybackContextTableAccessor extends HourlyUaPrtnAppClstPlaybackContextTableAccessor with connector.Connector
object TensecsUaPrtnCountryClstOsBrowserTableAccessor extends TensecsUaPrtnCountryClstOsBrowserTableAccessor with connector.Connector
object HourlyUaPrtnCv1Cv2TableAccessor extends HourlyUaPrtnCv1Cv2TableAccessor with connector.Connector
object HourlyUaPrtnCountryTableAccessor extends HourlyUaPrtnCountryTableAccessor with connector.Connector
object MinutelyUaPrtnAppTableAccessor extends MinutelyUaPrtnAppTableAccessor with connector.Connector
object MinutelyUaPrtnDeviceClstOsTableAccessor extends MinutelyUaPrtnDeviceClstOsTableAccessor with connector.Connector
object HourlyUaPrtnDeviceClstOsTableAccessor extends HourlyUaPrtnDeviceClstOsTableAccessor with connector.Connector
object MinutelyUaPrtnPlaybackContextTableAccessor extends MinutelyUaPrtnPlaybackContextTableAccessor with connector.Connector
object MinutelyUaPrtnCountryClstOsTableAccessor extends MinutelyUaPrtnCountryClstOsTableAccessor with connector.Connector
object HourlyUaPrtnCv1ClstCv2TableAccessor extends HourlyUaPrtnCv1ClstCv2TableAccessor with connector.Connector
object HourlyUaClstCountryTableAccessor extends HourlyUaClstCountryTableAccessor with connector.Connector
object HourlyUaPrtnCountryClstBrowserTableAccessor extends HourlyUaPrtnCountryClstBrowserTableAccessor with connector.Connector
object TensecsUaClstEntryTableAccessor extends TensecsUaClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCountryOsClstBrowserTableAccessor extends HourlyUaPrtnCountryOsClstBrowserTableAccessor with connector.Connector
object HourlyUaPrtnCv1TableAccessor extends HourlyUaPrtnCv1TableAccessor with connector.Connector
object HourlyUaPrtnCv3TableAccessor extends HourlyUaPrtnCv3TableAccessor with connector.Connector
object HourlyUaPrtnCv2TableAccessor extends HourlyUaPrtnCv2TableAccessor with connector.Connector
object HourlyUaClstCv1TableAccessor extends HourlyUaClstCv1TableAccessor with connector.Connector
object HourlyUaClstCv3TableAccessor extends HourlyUaClstCv3TableAccessor with connector.Connector
object HourlyUaClstCv2TableAccessor extends HourlyUaClstCv2TableAccessor with connector.Connector
object MinutelyUaPrtnCountryClstCityTableAccessor extends MinutelyUaPrtnCountryClstCityTableAccessor with connector.Connector
object HourlyUaPrtnReferrerTableAccessor extends HourlyUaPrtnReferrerTableAccessor with connector.Connector
object MinutelyUaPrtnOsTableAccessor extends MinutelyUaPrtnOsTableAccessor with connector.Connector
object HourlyUaClstDeviceTableAccessor extends HourlyUaClstDeviceTableAccessor with connector.Connector
object HourlyUaClstReferrerTableAccessor extends HourlyUaClstReferrerTableAccessor with connector.Connector
object MinutelyUaClstDomainTableAccessor extends MinutelyUaClstDomainTableAccessor with connector.Connector
object MinutelyUaPrtnOsClstBrowserTableAccessor extends MinutelyUaPrtnOsClstBrowserTableAccessor with connector.Connector
object TensecsUaPrtnReferrerTableAccessor extends TensecsUaPrtnReferrerTableAccessor with connector.Connector
object HourlyUaPrtnPlaybackContextTableAccessor extends HourlyUaPrtnPlaybackContextTableAccessor with connector.Connector
object MinutelyUaPrtnCv1Cv2ClstCv3TableAccessor extends MinutelyUaPrtnCv1Cv2ClstCv3TableAccessor with connector.Connector
object MinutelyUaPrtnCountryClstOsBrowserTableAccessor extends MinutelyUaPrtnCountryClstOsBrowserTableAccessor with connector.Connector
object HourlyUaPrtnDeviceOsTableAccessor extends HourlyUaPrtnDeviceOsTableAccessor with connector.Connector
object MinutelyUaPrtnCv1TableAccessor extends MinutelyUaPrtnCv1TableAccessor with connector.Connector
object MinutelyUaClstDeviceTableAccessor extends MinutelyUaClstDeviceTableAccessor with connector.Connector
object MinutelyUaPrtnCv3TableAccessor extends MinutelyUaPrtnCv3TableAccessor with connector.Connector
object MinutelyUaPrtnCv2TableAccessor extends MinutelyUaPrtnCv2TableAccessor with connector.Connector
object HourlyUaPrtnOsBrowserTableAccessor extends HourlyUaPrtnOsBrowserTableAccessor with connector.Connector
object HourlyUaPrtnCountryClstOsTableAccessor extends HourlyUaPrtnCountryClstOsTableAccessor with connector.Connector
object MinutelyUaClstBrowserTableAccessor extends MinutelyUaClstBrowserTableAccessor with connector.Connector
object MinutelyUaPrtnCv1Cv2Cv3TableAccessor extends MinutelyUaPrtnCv1Cv2Cv3TableAccessor with connector.Connector
object MinutelyUaClstEntryTableAccessor extends MinutelyUaClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCountryOsBrowserTableAccessor extends HourlyUaPrtnCountryOsBrowserTableAccessor with connector.Connector
object MinutelyUaClstCountryTableAccessor extends MinutelyUaClstCountryTableAccessor with connector.Connector
object MinutelyUaPrtnDeviceOsTableAccessor extends MinutelyUaPrtnDeviceOsTableAccessor with connector.Connector
object MinutelyUaPrtnCv1Cv2TableAccessor extends MinutelyUaPrtnCv1Cv2TableAccessor with connector.Connector
object TensecsUaClstOsTableAccessor extends TensecsUaClstOsTableAccessor with connector.Connector
object HourlyUaClstBrowserTableAccessor extends HourlyUaClstBrowserTableAccessor with connector.Connector
object HourlyUaClstDomainTableAccessor extends HourlyUaClstDomainTableAccessor with connector.Connector
object TensecsUaClstReferrerTableAccessor extends TensecsUaClstReferrerTableAccessor with connector.Connector
object HourlyUaClstAppTableAccessor extends HourlyUaClstAppTableAccessor with connector.Connector
object MinutelyUaPrtnCountryTableAccessor extends MinutelyUaPrtnCountryTableAccessor with connector.Connector
object HourlyUaPrtnCv1Cv2Cv3TableAccessor extends HourlyUaPrtnCv1Cv2Cv3TableAccessor with connector.Connector
object HourlyUaPrtnOsClstBrowserTableAccessor extends HourlyUaPrtnOsClstBrowserTableAccessor with connector.Connector
object TensecsUaPrtnCountryCityTableAccessor extends TensecsUaPrtnCountryCityTableAccessor with connector.Connector
object HourlyUaPrtnCv1Cv2ClstCv3TableAccessor extends HourlyUaPrtnCv1Cv2ClstCv3TableAccessor with connector.Connector
object HourlyUaPrtnDeviceTableAccessor extends HourlyUaPrtnDeviceTableAccessor with connector.Connector
object HourlyUaClstOsTableAccessor extends HourlyUaClstOsTableAccessor with connector.Connector
object HourlyUaClstEntryTableAccessor extends HourlyUaClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCountryClstBrowserTableAccessor extends MinutelyUaPrtnCountryClstBrowserTableAccessor with connector.Connector
object TensecsUaPrtnCountryClstCityTableAccessor extends TensecsUaPrtnCountryClstCityTableAccessor with connector.Connector
object MinutelyUaClstAppTableAccessor extends MinutelyUaClstAppTableAccessor with connector.Connector
object TensecsUaClstCountryCityTableAccessor extends TensecsUaClstCountryCityTableAccessor with connector.Connector
object MinutelyUaPrtnAppPlaybackContextTableAccessor extends MinutelyUaPrtnAppPlaybackContextTableAccessor with connector.Connector
object MinutelyUaPrtnEntryTableAccessor extends MinutelyUaPrtnEntryTableAccessor with connector.Connector
object MinutelyUaPrtnOsBrowserTableAccessor extends MinutelyUaPrtnOsBrowserTableAccessor with connector.Connector
object TensecsUaPrtnDomainClstReferrerTableAccessor extends TensecsUaPrtnDomainClstReferrerTableAccessor with connector.Connector
object MinutelyUaClstOsTableAccessor extends MinutelyUaClstOsTableAccessor with connector.Connector
object MinutelyUaPrtnDomainClstReferrerTableAccessor extends MinutelyUaPrtnDomainClstReferrerTableAccessor with connector.Connector
object MinutelyUaClstReferrerTableAccessor extends MinutelyUaClstReferrerTableAccessor with connector.Connector
object HourlyUaClstPlaybackContextTableAccessor extends HourlyUaClstPlaybackContextTableAccessor with connector.Connector
object TensecsUaClstDomainTableAccessor extends TensecsUaClstDomainTableAccessor with connector.Connector
object HourlyUaPrtnAppPlaybackContextTableAccessor extends HourlyUaPrtnAppPlaybackContextTableAccessor with connector.Connector
object MinutelyUaClstPlaybackContextTableAccessor extends MinutelyUaClstPlaybackContextTableAccessor with connector.Connector
object HourlyUaPrtnCountryClstOsBrowserTableAccessor extends HourlyUaPrtnCountryClstOsBrowserTableAccessor with connector.Connector
object TensecsUaPrtnAppTableAccessor extends TensecsUaPrtnAppTableAccessor with connector.Connector
object MinutelyUaPrtnDeviceTableAccessor extends MinutelyUaPrtnDeviceTableAccessor with connector.Connector
object TensecsUaPrtnEntryTableAccessor extends TensecsUaPrtnEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCountryOsClstBrowserTableAccessor extends MinutelyUaPrtnCountryOsClstBrowserTableAccessor with connector.Connector
object TensecsUaClstCountryTableAccessor extends TensecsUaClstCountryTableAccessor with connector.Connector
object MinutelyUaPrtnReferrerTableAccessor extends MinutelyUaPrtnReferrerTableAccessor with connector.Connector
object HourlyUaTableAccessor extends HourlyUaTableAccessor with connector.Connector
object HourlyUaPrtnDomainTableAccessor extends HourlyUaPrtnDomainTableAccessor with connector.Connector
object MinutelyUaPrtnBrowserTableAccessor extends MinutelyUaPrtnBrowserTableAccessor with connector.Connector
object MinutelyUaClstCv1TableAccessor extends MinutelyUaClstCv1TableAccessor with connector.Connector
object MinutelyUaClstCv3TableAccessor extends MinutelyUaClstCv3TableAccessor with connector.Connector
object MinutelyUaClstCv2TableAccessor extends MinutelyUaClstCv2TableAccessor with connector.Connector
object MinutelyUaPrtnCountryCityTableAccessor extends MinutelyUaPrtnCountryCityTableAccessor with connector.Connector
object HourlyUaPrtnOsTableAccessor extends HourlyUaPrtnOsTableAccessor with connector.Connector
object HourlyUaClstCountryCityTableAccessor extends HourlyUaClstCountryCityTableAccessor with connector.Connector
object TensecsUaPrtnDomainTableAccessor extends TensecsUaPrtnDomainTableAccessor with connector.Connector
object HourlyUaPrtnCountryClstCityTableAccessor extends HourlyUaPrtnCountryClstCityTableAccessor with connector.Connector
object HourlyUaPrtnBrowserTableAccessor extends HourlyUaPrtnBrowserTableAccessor with connector.Connector
object TensecsUaPrtnCountryTableAccessor extends TensecsUaPrtnCountryTableAccessor with connector.Connector
object HourlyUaPrtnAppTableAccessor extends HourlyUaPrtnAppTableAccessor with connector.Connector
object MinutelyUaTableAccessor extends MinutelyUaTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCv1ClstCv2TableAccessor extends MinutelyUaPrtnEntryCv1ClstCv2TableAccessor with connector.Connector
object TensecsUaPrtnEntryClstAppTableAccessor extends TensecsUaPrtnEntryClstAppTableAccessor with connector.Connector
object HourlyUaPrtnEntryCountryCityTableAccessor extends HourlyUaPrtnEntryCountryCityTableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstCountryCityTableAccessor extends MinutelyUaPrtnEntryClstCountryCityTableAccessor with connector.Connector
object HourlyUaPrtnEntryDomainClstReferrerTableAccessor extends HourlyUaPrtnEntryDomainClstReferrerTableAccessor with connector.Connector
object MinutelyUaPrtnEntryDomainTableAccessor extends MinutelyUaPrtnEntryDomainTableAccessor with connector.Connector
object TensecsUaPrtnEntryOsTableAccessor extends TensecsUaPrtnEntryOsTableAccessor with connector.Connector
object MinutelyUaPrtnEntryAppClstPlaybackContextTableAccessor extends MinutelyUaPrtnEntryAppClstPlaybackContextTableAccessor with connector.Connector
object HourlyUaPrtnEntryAppClstPlaybackContextTableAccessor extends HourlyUaPrtnEntryAppClstPlaybackContextTableAccessor with connector.Connector
object TensecsUaPrtnEntryCountryClstOsBrowserTableAccessor extends TensecsUaPrtnEntryCountryClstOsBrowserTableAccessor with connector.Connector
object HourlyUaPrtnEntryCv1Cv2TableAccessor extends HourlyUaPrtnEntryCv1Cv2TableAccessor with connector.Connector
object HourlyUaPrtnEntryCountryTableAccessor extends HourlyUaPrtnEntryCountryTableAccessor with connector.Connector
object MinutelyUaPrtnEntryAppTableAccessor extends MinutelyUaPrtnEntryAppTableAccessor with connector.Connector
object MinutelyUaPrtnEntryDeviceClstOsTableAccessor extends MinutelyUaPrtnEntryDeviceClstOsTableAccessor with connector.Connector
object HourlyUaPrtnEntryDeviceClstOsTableAccessor extends HourlyUaPrtnEntryDeviceClstOsTableAccessor with connector.Connector
object MinutelyUaPrtnEntryPlaybackContextTableAccessor extends MinutelyUaPrtnEntryPlaybackContextTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCountryClstOsTableAccessor extends MinutelyUaPrtnEntryCountryClstOsTableAccessor with connector.Connector
object HourlyUaPrtnEntryCv1ClstCv2TableAccessor extends HourlyUaPrtnEntryCv1ClstCv2TableAccessor with connector.Connector
object HourlyUaPrtnEntryClstCountryTableAccessor extends HourlyUaPrtnEntryClstCountryTableAccessor with connector.Connector
object HourlyUaPrtnEntryCv1TableAccessor extends HourlyUaPrtnEntryCv1TableAccessor with connector.Connector
object HourlyUaPrtnEntryCv3TableAccessor extends HourlyUaPrtnEntryCv3TableAccessor with connector.Connector
object HourlyUaPrtnEntryCv2TableAccessor extends HourlyUaPrtnEntryCv2TableAccessor with connector.Connector
object HourlyUaPrtnEntryClstCv1TableAccessor extends HourlyUaPrtnEntryClstCv1TableAccessor with connector.Connector
object HourlyUaPrtnEntryClstCv3TableAccessor extends HourlyUaPrtnEntryClstCv3TableAccessor with connector.Connector
object HourlyUaPrtnEntryClstCv2TableAccessor extends HourlyUaPrtnEntryClstCv2TableAccessor with connector.Connector
object MinutelyUaPrtnEntryCountryClstCityTableAccessor extends MinutelyUaPrtnEntryCountryClstCityTableAccessor with connector.Connector
object HourlyUaPrtnEntryReferrerTableAccessor extends HourlyUaPrtnEntryReferrerTableAccessor with connector.Connector
object MinutelyUaPrtnEntryOsTableAccessor extends MinutelyUaPrtnEntryOsTableAccessor with connector.Connector
object HourlyUaPrtnEntryClstDeviceTableAccessor extends HourlyUaPrtnEntryClstDeviceTableAccessor with connector.Connector
object HourlyUaPrtnEntryClstReferrerTableAccessor extends HourlyUaPrtnEntryClstReferrerTableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstDomainTableAccessor extends MinutelyUaPrtnEntryClstDomainTableAccessor with connector.Connector
object MinutelyUaPrtnEntryOsClstBrowserTableAccessor extends MinutelyUaPrtnEntryOsClstBrowserTableAccessor with connector.Connector
object TensecsUaPrtnEntryReferrerTableAccessor extends TensecsUaPrtnEntryReferrerTableAccessor with connector.Connector
object HourlyUaPrtnEntryPlaybackContextTableAccessor extends HourlyUaPrtnEntryPlaybackContextTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCv1Cv2ClstCv3TableAccessor extends MinutelyUaPrtnEntryCv1Cv2ClstCv3TableAccessor with connector.Connector
object HourlyUaPrtnEntryDeviceOsTableAccessor extends HourlyUaPrtnEntryDeviceOsTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCv1TableAccessor extends MinutelyUaPrtnEntryCv1TableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstDeviceTableAccessor extends MinutelyUaPrtnEntryClstDeviceTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCv3TableAccessor extends MinutelyUaPrtnEntryCv3TableAccessor with connector.Connector
object MinutelyUaPrtnEntryCv2TableAccessor extends MinutelyUaPrtnEntryCv2TableAccessor with connector.Connector
object HourlyUaPrtnEntryOsBrowserTableAccessor extends HourlyUaPrtnEntryOsBrowserTableAccessor with connector.Connector
object HourlyUaPrtnEntryCountryClstOsTableAccessor extends HourlyUaPrtnEntryCountryClstOsTableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstBrowserTableAccessor extends MinutelyUaPrtnEntryClstBrowserTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCv1Cv2Cv3TableAccessor extends MinutelyUaPrtnEntryCv1Cv2Cv3TableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstCountryTableAccessor extends MinutelyUaPrtnEntryClstCountryTableAccessor with connector.Connector
object MinutelyUaPrtnEntryDeviceOsTableAccessor extends MinutelyUaPrtnEntryDeviceOsTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCv1Cv2TableAccessor extends MinutelyUaPrtnEntryCv1Cv2TableAccessor with connector.Connector
object TensecsUaPrtnEntryClstOsTableAccessor extends TensecsUaPrtnEntryClstOsTableAccessor with connector.Connector
object HourlyUaPrtnEntryClstBrowserTableAccessor extends HourlyUaPrtnEntryClstBrowserTableAccessor with connector.Connector
object HourlyUaPrtnEntryClstDomainTableAccessor extends HourlyUaPrtnEntryClstDomainTableAccessor with connector.Connector
object TensecsUaPrtnEntryClstReferrerTableAccessor extends TensecsUaPrtnEntryClstReferrerTableAccessor with connector.Connector
object HourlyUaPrtnEntryClstAppTableAccessor extends HourlyUaPrtnEntryClstAppTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCountryTableAccessor extends MinutelyUaPrtnEntryCountryTableAccessor with connector.Connector
object HourlyUaPrtnEntryCv1Cv2Cv3TableAccessor extends HourlyUaPrtnEntryCv1Cv2Cv3TableAccessor with connector.Connector
object HourlyUaPrtnEntryOsClstBrowserTableAccessor extends HourlyUaPrtnEntryOsClstBrowserTableAccessor with connector.Connector
object TensecsUaPrtnEntryCountryCityTableAccessor extends TensecsUaPrtnEntryCountryCityTableAccessor with connector.Connector
object HourlyUaPrtnEntryCv1Cv2ClstCv3TableAccessor extends HourlyUaPrtnEntryCv1Cv2ClstCv3TableAccessor with connector.Connector
object HourlyUaPrtnEntryDeviceTableAccessor extends HourlyUaPrtnEntryDeviceTableAccessor with connector.Connector
object HourlyUaPrtnEntryClstOsTableAccessor extends HourlyUaPrtnEntryClstOsTableAccessor with connector.Connector
object MinutelyUaPrtnEntryCountryClstBrowserTableAccessor extends MinutelyUaPrtnEntryCountryClstBrowserTableAccessor with connector.Connector
object TensecsUaPrtnEntryCountryClstCityTableAccessor extends TensecsUaPrtnEntryCountryClstCityTableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstAppTableAccessor extends MinutelyUaPrtnEntryClstAppTableAccessor with connector.Connector
object TensecsUaPrtnEntryClstCountryCityTableAccessor extends TensecsUaPrtnEntryClstCountryCityTableAccessor with connector.Connector
object MinutelyUaPrtnEntryAppPlaybackContextTableAccessor extends MinutelyUaPrtnEntryAppPlaybackContextTableAccessor with connector.Connector
object MinutelyUaPrtnEntryOsBrowserTableAccessor extends MinutelyUaPrtnEntryOsBrowserTableAccessor with connector.Connector
object TensecsUaPrtnEntryDomainClstReferrerTableAccessor extends TensecsUaPrtnEntryDomainClstReferrerTableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstOsTableAccessor extends MinutelyUaPrtnEntryClstOsTableAccessor with connector.Connector
object MinutelyUaPrtnEntryDomainClstReferrerTableAccessor extends MinutelyUaPrtnEntryDomainClstReferrerTableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstReferrerTableAccessor extends MinutelyUaPrtnEntryClstReferrerTableAccessor with connector.Connector
object HourlyUaPrtnEntryClstPlaybackContextTableAccessor extends HourlyUaPrtnEntryClstPlaybackContextTableAccessor with connector.Connector
object TensecsUaPrtnEntryClstDomainTableAccessor extends TensecsUaPrtnEntryClstDomainTableAccessor with connector.Connector
object HourlyUaPrtnEntryAppPlaybackContextTableAccessor extends HourlyUaPrtnEntryAppPlaybackContextTableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstPlaybackContextTableAccessor extends MinutelyUaPrtnEntryClstPlaybackContextTableAccessor with connector.Connector
object TensecsUaPrtnEntryAppTableAccessor extends TensecsUaPrtnEntryAppTableAccessor with connector.Connector
object MinutelyUaPrtnEntryDeviceTableAccessor extends MinutelyUaPrtnEntryDeviceTableAccessor with connector.Connector
object TensecsUaPrtnEntryClstCountryTableAccessor extends TensecsUaPrtnEntryClstCountryTableAccessor with connector.Connector
object MinutelyUaPrtnEntryReferrerTableAccessor extends MinutelyUaPrtnEntryReferrerTableAccessor with connector.Connector
object HourlyUaPrtnEntryDomainTableAccessor extends HourlyUaPrtnEntryDomainTableAccessor with connector.Connector
object MinutelyUaPrtnEntryBrowserTableAccessor extends MinutelyUaPrtnEntryBrowserTableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstCv1TableAccessor extends MinutelyUaPrtnEntryClstCv1TableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstCv3TableAccessor extends MinutelyUaPrtnEntryClstCv3TableAccessor with connector.Connector
object MinutelyUaPrtnEntryClstCv2TableAccessor extends MinutelyUaPrtnEntryClstCv2TableAccessor with connector.Connector
object MinutelyUaPrtnEntryCountryCityTableAccessor extends MinutelyUaPrtnEntryCountryCityTableAccessor with connector.Connector
object HourlyUaPrtnEntryOsTableAccessor extends HourlyUaPrtnEntryOsTableAccessor with connector.Connector
object HourlyUaPrtnEntryClstCountryCityTableAccessor extends HourlyUaPrtnEntryClstCountryCityTableAccessor with connector.Connector
object TensecsUaPrtnEntryDomainTableAccessor extends TensecsUaPrtnEntryDomainTableAccessor with connector.Connector
object HourlyUaPrtnEntryCountryClstCityTableAccessor extends HourlyUaPrtnEntryCountryClstCityTableAccessor with connector.Connector
object HourlyUaPrtnEntryBrowserTableAccessor extends HourlyUaPrtnEntryBrowserTableAccessor with connector.Connector
object TensecsUaPrtnEntryCountryTableAccessor extends TensecsUaPrtnEntryCountryTableAccessor with connector.Connector
object HourlyUaPrtnEntryAppTableAccessor extends HourlyUaPrtnEntryAppTableAccessor with connector.Connector
object HourlyUaPrtnCategoryTableAccessor extends HourlyUaPrtnCategoryTableAccessor with connector.Connector
object HourlyUaClstCategoryTableAccessor extends HourlyUaClstCategoryTableAccessor with connector.Connector
object MinutelyUaPrtnCategoryTableAccessor extends MinutelyUaPrtnCategoryTableAccessor with connector.Connector
object MinutelyUaClstCategoryTableAccessor extends MinutelyUaClstCategoryTableAccessor with connector.Connector
object TensecsUaPrtnCategoryTableAccessor extends TensecsUaPrtnCategoryTableAccessor with connector.Connector
object TensecsUaClstCategoryTableAccessor extends TensecsUaClstCategoryTableAccessor with connector.Connector
object HourlyUaPrtnCategoryClstEntryTableAccessor extends HourlyUaPrtnCategoryClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCategoryClstEntryTableAccessor extends MinutelyUaPrtnCategoryClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnAppClstEntryTableAccessor extends HourlyUaPrtnAppClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnAppClstEntryTableAccessor extends MinutelyUaPrtnAppClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnAppPlaybackContextClstEntryTableAccessor extends HourlyUaPrtnAppPlaybackContextClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnAppPlaybackContextClstEntryTableAccessor extends MinutelyUaPrtnAppPlaybackContextClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnBrowserClstEntryTableAccessor extends HourlyUaPrtnBrowserClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnBrowserClstEntryTableAccessor extends MinutelyUaPrtnBrowserClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCountryClstEntryTableAccessor extends HourlyUaPrtnCountryClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCountryClstEntryTableAccessor extends MinutelyUaPrtnCountryClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCountryCityClstEntryTableAccessor extends HourlyUaPrtnCountryCityClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCountryCityClstEntryTableAccessor extends MinutelyUaPrtnCountryCityClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCv1ClstEntryTableAccessor extends HourlyUaPrtnCv1ClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCv1ClstEntryTableAccessor extends MinutelyUaPrtnCv1ClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCv2ClstEntryTableAccessor extends HourlyUaPrtnCv2ClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCv2ClstEntryTableAccessor extends MinutelyUaPrtnCv2ClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCv3ClstEntryTableAccessor extends HourlyUaPrtnCv3ClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCv3ClstEntryTableAccessor extends MinutelyUaPrtnCv3ClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCv1Cv2ClstEntryTableAccessor extends HourlyUaPrtnCv1Cv2ClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCv1Cv2ClstEntryTableAccessor extends MinutelyUaPrtnCv1Cv2ClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnCv1Cv2Cv3ClstEntryTableAccessor extends HourlyUaPrtnCv1Cv2Cv3ClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnCv1Cv2Cv3ClstEntryTableAccessor extends MinutelyUaPrtnCv1Cv2Cv3ClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnDeviceClstEntryTableAccessor extends HourlyUaPrtnDeviceClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnDeviceClstEntryTableAccessor extends MinutelyUaPrtnDeviceClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnDeviceOsClstEntryTableAccessor extends HourlyUaPrtnDeviceOsClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnDeviceOsClstEntryTableAccessor extends MinutelyUaPrtnDeviceOsClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnDomainClstEntryTableAccessor extends HourlyUaPrtnDomainClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnDomainClstEntryTableAccessor extends MinutelyUaPrtnDomainClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnReferrerClstEntryTableAccessor extends HourlyUaPrtnReferrerClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnReferrerClstEntryTableAccessor extends MinutelyUaPrtnReferrerClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnOsClstEntryTableAccessor extends HourlyUaPrtnOsClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnOsClstEntryTableAccessor extends MinutelyUaPrtnOsClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnOsBrowserClstEntryTableAccessor extends HourlyUaPrtnOsBrowserClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnOsBrowserClstEntryTableAccessor extends MinutelyUaPrtnOsBrowserClstEntryTableAccessor with connector.Connector
object HourlyUaPrtnPlaybackContextClstEntryTableAccessor extends HourlyUaPrtnPlaybackContextClstEntryTableAccessor with connector.Connector
object MinutelyUaPrtnPlaybackContextClstEntryTableAccessor extends MinutelyUaPrtnPlaybackContextClstEntryTableAccessor with connector.Connector
object TensecsUaTableAccessor extends TensecsUaTableAccessor with connector.Connector

}