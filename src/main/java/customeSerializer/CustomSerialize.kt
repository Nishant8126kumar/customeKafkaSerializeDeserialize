package customeSerializer

import com.fasterxml.jackson.databind.ObjectMapper
import model.User
import org.apache.kafka.common.serialization.Serializer

class CustomSerialize :Serializer<User>{

    private val objectMapper=ObjectMapper()
    override fun serialize(topic: String?, data: User?): ByteArray {
        return objectMapper.writeValueAsString(data).toByteArray()
    }
}
