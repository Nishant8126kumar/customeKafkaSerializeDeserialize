package consumers

import KAFKA_BROKER
import KAFKA_DESERIALIZER
import KAFKA_GROUP
import KAFKA_TOPIC
import customeDeserializer.CustomDeserialize
import model.User
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import java.util.*

class ConsumerHelper {

    companion object
    {
        fun consumerProvide():KafkaConsumer<String,User>
        {
            val properties=Properties()
            properties[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG]=KAFKA_BROKER
            properties[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG]=KAFKA_DESERIALIZER
            properties[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG]=CustomDeserialize::class.java
            properties[ConsumerConfig.GROUP_ID_CONFIG]=KAFKA_GROUP
            val kafkaConsumer=KafkaConsumer<String,User>(properties)
            val list= arrayListOf<String>()
            list.add(KAFKA_TOPIC)
            kafkaConsumer.subscribe(list)
            return kafkaConsumer
        }
    }
}

