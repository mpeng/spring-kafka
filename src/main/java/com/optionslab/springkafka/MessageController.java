package com.optionslab.springkafka;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;

@RestController
@RequestMapping( "api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish( @RequestBody MessageRequest request) {
        kafkaTemplate.send( "optionslab", request.message());
    }
}
