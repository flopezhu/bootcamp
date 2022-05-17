package com.api.rest.springboot.bootcamp;

import com.api.rest.springboot.bootcamp.controllers.CustomerController;
import com.api.rest.springboot.bootcamp.dto.CustomerDto;
import com.api.rest.springboot.bootcamp.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

import java.util.*;

@RunWith(SpringRunner.class)
@WebFluxTest(CustomerController.class)
class ApiRestSpringbootBootcampApplicationTests {

    private WebTestClient webTestClient;

    @MockBean
    private CustomerService customerService;

    @Test
    public void addCustomerTest() {
        Mono<CustomerDto> customerDtoMono = Mono.just(CustomerDto.builder()
                .id(UUID.randomUUID().toString())
                .code("bcp123")
                .name("Franclin")
                .lastName("Lopez")
                .sex("Masculino")
                .dateBirth(new Date())
                .documentType("DNI")
                .documentNumber("12345678")
                .address("av lima 123")
                .phone("123456789")
                .email("franclinlh@gmail.com")
                .customerTypeList(new ArrayList<>())
                .productList(new ArrayList<>())
                .build()
        );
        when(customerService.save(customerDtoMono)).thenReturn(customerDtoMono);
        webTestClient.post().uri("/api/customers")
                .body(Mono.just(customerDtoMono)
                        , CustomerDto.class)
                .exchange()
                .expectStatus().isOk(); //200
    }

    @Test
    public void getCustomersTest() {
        Flux<CustomerDto> customerDtoFlux = Flux.just(CustomerDto.builder()
                .id(UUID.randomUUID().toString())
                .code("bcp123")
                .name("Franclin")
                .lastName("Lopez")
                .sex("Masculino")
                .dateBirth(new Date())
                .documentType("DNI")
                .documentNumber("12345678")
                .address("av lima 123")
                .phone("123456789")
                .email("franclinlh@gmail.com")
                .customerTypeList(new ArrayList<>())
                .productList(new ArrayList<>())
                .build()
        );

        when(customerService.findAll()).thenReturn(customerDtoFlux);

        Flux<CustomerDto> responseBody = webTestClient.get().uri("/api/customers")
                .exchange()
                .expectStatus().isOk()
                .returnResult(CustomerDto.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNext(CustomerDto.builder()
                        .id(UUID.randomUUID().toString())
                        .code("bcp123")
                        .name("Franclin")
                        .lastName("Lopez")
                        .sex("Masculino")
                        .dateBirth(new Date())
                        .documentType("DNI")
                        .documentNumber("12345678")
                        .address("av lima 123")
                        .phone("123456789")
                        .email("franclinlh@gmail.com")
                        .customerTypeList(new ArrayList<>())
                        .productList(new ArrayList<>())
                        .build())
                .verifyComplete();

    }

    @Test
    public void getCustomerForId() {
        //Mono<CustomerDto>
    }

}
