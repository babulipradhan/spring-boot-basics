package babuli.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        String key = String.valueOf(System.nanoTime());
        message = message + "-" + key;
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, "Message-" + key);
        log.info("Sending message : {}", message);
        CompletableFuture<SendResult<String, String>> cf = kafkaTemplate.send(producerRecord);
        try {
            SendResult<String, String> result = cf.get();
            RecordMetadata metadata = result.getRecordMetadata();
            log.info(metadata.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
