package com.api.rest.bootcamp.customer;

import com.api.rest.bootcamp.controller.CustomerController;
import com.api.rest.bootcamp.dto.CustomerDto;
import com.api.rest.bootcamp.service.CustomerService;
import com.api.rest.bootcamp.service.CustomerTypeService;
import com.api.rest.bootcamp.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(CustomerController.class)
public class CustomerTest {
    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private CustomerService customerService;

    @MockBean
    private CustomerTypeService customerTypeService;

    @MockBean
    private ProductService productService;

    @Test
    public void addCustomerTest() {
        Mono<CustomerDto> customerDtoMono = Mono
                .just(CustomerDto.builder()
                        .id(UUID.randomUUID().toString())
                        .code("bcp123")
                        .name("Franclin")
                        .lastName("Lopez")
                        .sex("Masculino")
                        .dateBirth(new Date("12-11-0017"))
                        .documentType("DNI")
                        .documentNumber("12345678")
                        .address("av lima 123")
                        .phone("123456789")
                        .email("franclinlh@gmail.com")
                        .customerTypeId("123")
                        .productId("1234")
                        .bankAccountId("999999999")
                        .createdDate(new Date("30-05-2022 03:26:57"))
                        .build()
                );
        when(customerService.save(customerDtoMono))
                .thenReturn(customerDtoMono);
        Assertions.assertNotNull(customerService
                .save(customerDtoMono));
        webTestClient.post().uri("/api/customers/")
                .body(Mono.just(customerDtoMono)
                        , CustomerDto.class)
                .exchange()
                .expectStatus().isOk(); //200
    }

    @Test
    public void getCustomersTest() {
        Flux<CustomerDto> customerDtoFlux = Flux.just(
                CustomerDto.builder()
                        .id("123")
                        .code("bcp123")
                        .name("Franclin")
                        .lastName("Lopez")
                        .sex("Masculino")
                        .documentType("DNI")
                        .documentNumber("12345678")
                        .address("av lima 123")
                        .phone("123456789")
                        .email("franclinlh@gmail.com")
                        .customerTypeId("123")
                        .productId("1234")
                        .bankAccountId("999999999")
                        .build(),
                CustomerDto.builder()
                        .id("345")
                        .code("bcp123")
                        .name("Franclin")
                        .lastName("Lopez")
                        .sex("Masculino")
                        .documentType("DNI")
                        .documentNumber("12345678")
                        .address("av lima 123")
                        .phone("123456789")
                        .email("franclinlh@gmail.com")
                        .customerTypeId("123")
                        .productId("1234")
                        .bankAccountId("999999999")
                        .build(),
                CustomerDto.builder()
                        .id("678")
                        .code("bcp123")
                        .name("Franclin")
                        .lastName("Lopez")
                        .sex("Masculino")
                        .documentType("DNI")
                        .documentNumber("12345678")
                        .address("av lima 123")
                        .phone("123456789")
                        .email("franclinlh@gmail.com")
                        .customerTypeId("123")
                        .productId("1234")
                        .bankAccountId("999999999")
                        .build(),
                CustomerDto.builder()
                        .id("911")
                        .code("bcp123")
                        .name("Franclin")
                        .lastName("Lopez")
                        .sex("Masculino")
                        .documentType("DNI")
                        .documentNumber("12345678")
                        .address("av lima 123")
                        .phone("123456789")
                        .email("franclinlh@gmail.com")
                        .customerTypeId("123")
                        .productId("1234")
                        .bankAccountId("999999999")
                        .build(),
                CustomerDto.builder()
                        .id("1011")
                        .code("bcp123")
                        .name("Franclin")
                        .lastName("Lopez")
                        .sex("Masculino")
                        .documentType("DNI")
                        .documentNumber("12345678")
                        .address("av lima 123")
                        .phone("123456789")
                        .email("franclinlh@gmail.com")
                        .customerTypeId("123")
                        .productId("1234")
                        .bankAccountId("999999999")
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
                .expectNext(
                        CustomerDto.builder()
                                .id("123")
                                .code("bcp123")
                                .name("Franclin")
                                .lastName("Lopez")
                                .sex("Masculino")
                                .documentType("DNI")
                                .documentNumber("12345678")
                                .address("av lima 123")
                                .phone("123456789")
                                .email("franclinlh@gmail.com")
                                .customerTypeId("123")
                                .productId("1234")
                                .bankAccountId("999999999")
                                .build(),
                        CustomerDto.builder()
                                .id("456")
                                .code("bcp123")
                                .name("Franclin")
                                .lastName("Lopez")
                                .sex("Masculino")
                                .documentType("DNI")
                                .documentNumber("12345678")
                                .address("av lima 123")
                                .phone("123456789")
                                .email("franclinlh@gmail.com")
                                .customerTypeId("123")
                                .productId("1234")
                                .bankAccountId("999999999")
                                .build(),
                        CustomerDto.builder()
                                .id("789")
                                .code("bcp123")
                                .name("Franclin")
                                .lastName("Lopez")
                                .sex("Masculino")
                                .documentType("DNI")
                                .documentNumber("12345678")
                                .address("av lima 123")
                                .phone("123456789")
                                .email("franclinlh@gmail.com")
                                .customerTypeId("123")
                                .productId("1234")
                                .bankAccountId("999999999")
                                .build(),
                        CustomerDto.builder()
                                .id("911")
                                .code("bcp123")
                                .name("Franclin")
                                .lastName("Lopez")
                                .sex("Masculino")
                                .documentType("DNI")
                                .documentNumber("12345678")
                                .address("av lima 123")
                                .phone("123456789")
                                .email("franclinlh@gmail.com")
                                .customerTypeId("123")
                                .productId("1234")
                                .bankAccountId("999999999")
                                .build(),
                        CustomerDto.builder()
                                .id("1011")
                                .code("bcp123")
                                .name("Franclin")
                                .lastName("Lopez")
                                .sex("Masculino")
                                .documentType("DNI")
                                .documentNumber("12345678")
                                .address("av lima 123")
                                .phone("123456789")
                                .email("franclinlh@gmail.com")
                                .customerTypeId("123")
                                .productId("1234")
                                .bankAccountId("999999999")
                                .build())
                .verifyComplete();

    }
}
