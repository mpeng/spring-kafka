package com.optionslab.springkafka;

import org.springframework.stereotype.Component;
import  org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "optionslab", groupId = "hroupId" )
    void  listener(String data) {
        System.out.println( "Listener received: " + data + " " );
    }
}
