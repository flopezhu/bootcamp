package com.api.rest.bootcamp.web.expose;

import com.api.rest.bootcamp.kafka.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public ResponseEntity<String> requestTransaction(@RequestBody String transaction) {
        kafkaProducer.publishMessage(transaction);
        log.info("start send transaction:" + transaction);
        return ResponseEntity.ok(transaction);
    }
}
