package babuli.kafka.service.impl;

import babuli.kafka.service.KafkaConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerServiceImplPart1 implements KafkaConsumerService {
    public void consumeMessage(String message) {
        log.info("Consumed message: " + message);
    }
}
