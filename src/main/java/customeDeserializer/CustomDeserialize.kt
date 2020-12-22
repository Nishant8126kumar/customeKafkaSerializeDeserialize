package customeDeserializer

import com.fasterxml.jackson.databind.ObjectMapper
import model.User
import org.apache.kafka.common.serialization.Deserializer

class CustomDeserialize :Deserializer<User> {
    private val objectMapper=ObjectMapper()
    override fun deserialize(topic: String?, data: ByteArray?): User? {
        try {
            return objectMapper.readValue(data,User::class.java)
        } catch (e: Exception) {
            println("Exception are occured=:${e.message}")
        }
        return null
    }

}