package com.kaltura.core.cassandra

import com.datastax.driver.core.{Cluster, Session}

/**
 * Created by ofirk on 26/01/2016.
 */
object ClusterManager {
  private val cluster = Cluster.builder()
            .addContactPoint("127.0.0.1")
            .build()

  private val session = cluster.connect()

  def getSession = session

  def close() = if (cluster != null) cluster.close()
}
