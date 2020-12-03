package com.kafka.producer.controller;

import com.kafka.producer.model.Student;
import com.kafka.producer.model.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired private KafkaTemplate<String, Student> kafkaTemplate;

    private static final String TOPIC = "Student_Info";
    private static final String SUCCESS_MESSAGE = "Successfully written to topic " + TOPIC;
    @PostMapping
    public ResponseEntity<SuccessResponse> post(@RequestBody Student student) {
        kafkaTemplate.send(TOPIC, student);
        return ResponseEntity.ok(
                SuccessResponse.builder()
                        .status(200)
                        .message(SUCCESS_MESSAGE)
                        .build()
        );
    }
}
