package fr.delberghea.demospringkafka.consumer;

import fr.delberghea.demospringkafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "firstTopic", groupId = "myGroup")
    public void consumeMessage(String msg) {
        log.info(String.format("ConsumedMessage :: %s", msg));
    }

    @KafkaListener(topics = "studentTopic", groupId = "myGroup")
    public void consumeJsonMessage(Student student) {
        log.info(String.format("ConsumedMessage :: %s", student.toString()));
    }

}
