package babuli.kafka.controller;

import babuli.kafka.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/v1/api/kafka")
@Slf4j
public class KafkaController {

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    private final KafkaProducerService kafkaProducerService;

    public KafkaController(final KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/message/{message-count}")
    public String postMessages(@PathVariable("message-count") int messageCount) {
        log.info("Message count is {}", messageCount);
        Runnable producer = () -> {
            kafkaProducerService.sendMessage("my-topic", "Message");
        };
        for (int i = 0; i < messageCount; i++) {
            executorService.submit(producer);

        }
        return "Request initiated";
    }
}
