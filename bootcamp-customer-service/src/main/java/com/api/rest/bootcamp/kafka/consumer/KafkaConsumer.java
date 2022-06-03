package com.api.rest.bootcamp.kafka.consumer;

import com.api.rest.bootcamp.model.Transaction;
import com.api.rest.bootcamp.service.TransactionService;
import com.api.rest.bootcamp.util.AppUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {
    @Autowired
    private TransactionService transactionService;
    /**
     * @param message
     */
    @KafkaListener(topics = "${kafka.subscribed-topic.name}")
    public void consumeEvent(final String message) throws JsonProcessingException, InterruptedException {
        log.info("Message received " + message);
        transactionService.processTransaction(transaction(message));
    }

    /**
     * @param message
     * @return new instance transaction.
     * @throws JsonProcessingException
     */
    private Transaction transaction(final String message)
            throws JsonProcessingException {
        return AppUtils.objectMapper
                .readValue(message, Transaction.class);
    }
}
