package com.api.rest.bootcamp.config;

import com.api.rest.bootcamp.documents.Assurance;
import com.api.rest.bootcamp.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class AssuranceDataLoader implements ApplicationRunner {
    @Autowired
    private AssuranceService bankFeeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (Objects.equals(bankFeeService.count().block(), 0L)) {
            Mono<Assurance> bankFee1 =
                    Flux.just(Assurance.builder().id(UUID.randomUUID().toString())
                            .description("Bank fees number 1")
                            .minimumAmount(BigDecimal.valueOf(0))
                            .maximumAmount(BigDecimal.valueOf(500))
                            .price(BigDecimal.valueOf(5.50))
                            .status("1")
                            .build(),
                    Assurance.builder().id(UUID.randomUUID().toString())
                            .description("Bank fees number 2")
                            .minimumAmount(BigDecimal.valueOf(500))
                            .maximumAmount(BigDecimal.valueOf(930))
                            .price(BigDecimal.valueOf(8.70))
                            .status("1")
                            .build(),
                    Assurance.builder().id(UUID.randomUUID().toString())
                            .description("Bank fees number 3")
                            .minimumAmount(BigDecimal.valueOf(930))
                            .maximumAmount(BigDecimal.valueOf(1500))
                            .price(BigDecimal.valueOf(10.70))
                            .status("1")
                            .build(),
                    Assurance.builder().id(UUID.randomUUID().toString())
                            .description("Bank fees number 4")
                            .minimumAmount(BigDecimal.valueOf(1500))
                            .maximumAmount(BigDecimal.valueOf(3500))
                            .price(BigDecimal.valueOf(13.80))
                            .status("1")
                            .build(),
                    Assurance.builder().id(UUID.randomUUID().toString())
                            .description("Bank fees number 4")
                            .minimumAmount(BigDecimal.valueOf(3500))
                            .maximumAmount(BigDecimal.valueOf(5000))
                            .price(BigDecimal.valueOf(20.00))
                            .status("0")
                            .build())
                            .take(1)
                            .single();
            List.of(bankFee1)
                    .forEach(bankFee -> System.out.println("list mono"+ bankFee));
        }
    }
}
