package ch.taggiasco.streams

import com.typesafe.config.ConfigFactory


trait Config {
  private val config = ConfigFactory.load()
  private val jmsConfig = config.getConfig("interface")
  
  val jmsUrl = jmsConfig.getString("url")
  val jmsQueueName = jmsConfig.getString("queue")
}
