package babuli.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaConsumerService {
    @KafkaListener(topics = "my-topic", groupId = "my-consumer-group")
    void consumeMessage(String message);
}
