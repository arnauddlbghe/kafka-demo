package fr.delberghea.demospringkafka.controller;

import fr.delberghea.demospringkafka.payload.Student;
import fr.delberghea.demospringkafka.producer.KafkaJsonProducer;
import fr.delberghea.demospringkafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message published successfully.");
    }

    @PostMapping("student")
    public ResponseEntity<String> publishMessage(@RequestBody Student student) {
        kafkaJsonProducer.publishMessage(student);
        return ResponseEntity.ok("Message published successfully as JSON.");
    }

}
