package ch.taggiasco.streams

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._
import akka.stream.alpakka.jms.scaladsl.JmsSink
import akka.stream.alpakka.jms.JmsSinkSettings
import akka.stream.alpakka.jms.JmsSourceSettings
import akka.stream.alpakka.jms.scaladsl.JmsSource
import scala.util.Random
import scala.util.{Success, Failure}
import org.apache.activemq.ActiveMQConnectionFactory


object JmsApp extends Config {

  def main(args: Array[String]): Unit = {
    // actor system and implicit materializer
    implicit val system = ActorSystem("system")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = materializer.executionContext
    
    val connectionFactory = new ActiveMQConnectionFactory(jmsUrl)
    
    val jmsSink: Sink[String, NotUsed] = JmsSink(
      JmsSinkSettings(connectionFactory).withQueue(jmsQueueName)
    )
    
    //val numbers = Source.fromIterator(() => Iterator.continually(Random.nextInt()))
    //val graph = numbers.via(Flow[Int].map(e => e.toString())).runWith(jmsSink)
    
    val in = List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
    Source(in).runWith(jmsSink)
    
    
    
    val jmsSource: Source[String, NotUsed] = JmsSource.textSource(
      JmsSourceSettings(connectionFactory).withBufferSize(10).withQueue(jmsQueueName)
    )
    
    val result = jmsSource.take(in.size).runWith(Sink.seq)
    
    result.onComplete {
      case Success(strs) => println("Result: " + strs)
      case Failure(e)    => println("Error: " + e.getMessage)
    }
    
  }
}
