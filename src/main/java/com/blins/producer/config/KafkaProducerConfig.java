package com.blins.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {
    public NewTopic createTopic(){
        return new NewTopic("producer-test",5,(short) 1);
    }
}
