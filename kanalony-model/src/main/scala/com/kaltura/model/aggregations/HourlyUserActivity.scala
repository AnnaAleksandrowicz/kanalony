package com.kaltura.model.aggregations

import org.joda.time.DateTime
import com.kaltura.core.userAgent.enums.{Browser, OperatingSystem, Device}

case class HourlyPartner(partnerId: Int, metric: Int, year: Int, hour: DateTime, value: Long)
case class HourlyPartnerCountry(partnerId: Int, metric: Int, year: Int, hour: DateTime, country: String, value: Long)
case class HourlyPartnerCountryCity(partnerId: Int, metric: Int, year: Int, hour: DateTime, country: String, city: String, value: Long)
case class HourlyPartnerDomain(partnerId: Int, metric: Int, year: Int, hour: DateTime, domain: String, value: Long)
case class HourlyPartnerReferrer(partnerId: Int, metric: Int, year: Int, hour: DateTime, referrer: String, value: Long)
case class HourlyPartnerDomainReferrer(partnerId: Int, metric: Int, year: Int, hour: DateTime, domain: String, referrer: String, value: Long)
case class HourlyPartnerDevice(partnerId: Int, metric: Int, year: Int, hour: DateTime, device: Int, value: Long)
case class HourlyPartnerOperatingSystem(partnerId: Int, metric: Int, year: Int, hour: DateTime, operatingSystem: Int, value: Long)
case class HourlyPartnerBrowser(partnerId: Int, metric: Int, year: Int, hour: DateTime, browser: Int, value: Long)
case class HourlyPartnerDeviceOperatingSystem(partnerId: Int, metric: Int, year: Int, hour: DateTime, device: Int, operatingSystem: Int, value: Long)
case class HourlyPartnerOperatingSystemBrowser(partnerId: Int, metric: Int, year: Int, hour: DateTime, operatingSystem: Int, browser: Int, value: Long)
case class HourlyPartnerApplication(partnerId: Int, metric: Int, year: Int, hour: DateTime, application: String, value: Long)
case class HourlyPartnerPlaybackContext(partnerId: Int, metric: Int, year: Int, hour: DateTime, playbackContext: Long, value: Long)
case class HourlyPartnerApplicationPlaybackContext(partnerId: Int, metric: Int, year: Int, hour: DateTime, application: String, playbackContext: Long, value: Long)
case class HourlyPartnerCountryOperatingSystemBrowser(partnerId: Int, metric: Int, year: Int, hour: DateTime, country: String, operatingSystem: Int, browser: Int, value: Long)
case class HourlyPartnerCountryOperatingSystem(partnerId: Int, metric: Int, year: Int, hour: DateTime, country: String, operatingSystem: Int, value: Long)
case class HourlyPartnerCountryBrowser(partnerId: Int, metric: Int, year: Int, hour: DateTime, country: String, browser: Int, value: Long)



case class HourlyEntry(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, value: Long)
case class HourlyEntryCountry(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, country: String, value: Long)
case class HourlyEntryCountryCity(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, country: String, city: String, value: Long)
case class HourlyEntryDomain(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, domain: String, value: Long)
case class HourlyEntryDomainReferrer(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, referrer: String, value: Long)
case class HourlyEntryReferrer(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, domain: String, referrer: String, value: Long)
case class HourlyEntryDevice(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, device: Int, value: Long)
case class HourlyEntryOperatingSystem(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, operatingSystem: Int, value: Long)
case class HourlyEntryBrowser(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, browser: Int, value: Long)
case class HourlyEntryDeviceOperatingSystem(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, device: Int, operatingSystem: Int, value: Long)
case class HourlyEntryOperationSystemBrowser(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, operatingSystem: Int, browser: Int, value: Long)
case class HourlyEntryApplication(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, application: String, value: Long)
case class HourlyEntryPlaybackContext(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, playbackContext: Long, value: Long)
case class HourlyEntryApplicationPlaybackContext(partnerId: Int, entryId: String, metric: Int, year: Int, hour: DateTime, application: String, playbackContext: Long, value: Long)
