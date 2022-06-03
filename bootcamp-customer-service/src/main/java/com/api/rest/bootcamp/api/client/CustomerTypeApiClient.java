package com.api.rest.bootcamp.api.client;

import com.api.rest.bootcamp.api.client.response.CustomerTypeResponse;
import com.api.rest.bootcamp.dto.CustomerTypeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@Slf4j
@Component
public class CustomerTypeApiClient {
    @Autowired
    private WebClient webClient;

    public List<CustomerTypeResponse> getAllCustomerType() throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        List<CustomerTypeResponse> result = new ArrayList<>();
        webClient.get()
                .uri("/api/customerType/")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(CustomerTypeResponse.class)
                .publishOn(Schedulers.fromExecutor(executor))
                .subscribe(result::add);
        executor.awaitTermination(1, TimeUnit.SECONDS);
        log.info("Customer type list " + result);
        return result;
    }
}
