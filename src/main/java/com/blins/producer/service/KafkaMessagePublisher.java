package com.blins.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String, Object> template;

    public  void  sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("producer-test", message);
        future.whenComplete((stringObjectSendResult, throwable) -> {
            if (throwable==null){
                System.out.println("Sent message=["+message+"] with offset=["+stringObjectSendResult.getRecordMetadata().offset()+"]");
            }
            else{
                System.out.println("Unable to send message=["+message+"] due to:" +throwable.getMessage());
            }
        });
    }
}
