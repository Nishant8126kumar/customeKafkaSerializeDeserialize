import consumers.ConsumerHelper
import model.User
import org.apache.kafka.clients.producer.ProducerRecord
import producers.ProducerHelper
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.log

fun producerRun()
{
    try {
        val producer=ProducerHelper.producerProvide()
        val id=UUID.randomUUID().toString()
        val user=User(20,"Shivam Sharma","8126632694")
        val s= producer.send(ProducerRecord(KAFKA_TOPIC,id,user))
        var record=s.get(5000,TimeUnit.MINUTES)
        println("OffSet=:${record.offset()}")
        println("partition=:${record.partition()}")
        println("topic=:${record.topic()}")
    } catch (e: Exception) {
        println("exception=:${e.message}")
    }
}
fun consumerRun()
{
    val consumer=ConsumerHelper.consumerProvide()
    while (true)
    {
        val consumerRecords = consumer.poll(1000)
        for (record in consumerRecords)
        {
            println("data=:${record.value()}")
        }
    }
}

fun main()
{
    Thread()
    {
        producerRun()
    }.start()

    Thread()
    {
        consumerRun()
    }.start()
}


//var user=User(10,"Nishant")
//var s=producer.send(ProducerRecord(KafkaConstant.kafkaTopic,id,user))
//var record=s.get(5000, TimeUnit.MINUTES)
//println("Offset=:${record.offset()}")
//print("partiton=:${record.partition()}")
//print("topic=:${record.topic()}")