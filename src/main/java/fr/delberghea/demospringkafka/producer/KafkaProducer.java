package fr.delberghea.demospringkafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String msg) {
        log.info(String.format("Sending message to firstTopic :: %s", msg));
        kafkaTemplate.send("firstTopic", msg);
    }

}
