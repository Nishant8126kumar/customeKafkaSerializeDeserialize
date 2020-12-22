package producers

import KAFKA_BROKER
import KAFKA_SERIALIZER
import customeSerializer.CustomSerialize
import model.User
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import java.util.*

class ProducerHelper {
    companion object
    {
        fun producerProvide():KafkaProducer<String, User>
        {
            val properties=Properties()
            properties[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG]=KAFKA_BROKER
            properties[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG]=KAFKA_SERIALIZER
            properties[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG]=CustomSerialize::class.java
            return KafkaProducer<String,User>(properties)
        }
    }
}
