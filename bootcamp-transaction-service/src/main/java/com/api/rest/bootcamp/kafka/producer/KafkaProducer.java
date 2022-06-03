package com.api.rest.bootcamp.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.topic.name}")
    private String topic;

    public void publishMessage(String message) {
        ListenableFuture<SendResult<String, String>> futureMessage = kafkaTemplate.send(this.topic, message);
        futureMessage.addCallback(new ListenableFutureCallback<>() {
            @Override public void onFailure(Throwable ex) {
                log.error("There was an error while sending message: {}", ex.getMessage());
            }

            @Override public void onSuccess(SendResult<String, String> result) {
                log.info("Message {} has been sent to the topic successfully ", message );
            }
        });
    }
}
