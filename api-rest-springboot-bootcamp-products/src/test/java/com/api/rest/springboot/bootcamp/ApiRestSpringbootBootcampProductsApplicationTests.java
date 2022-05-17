package com.api.rest.springboot.bootcamp;

import com.api.rest.springboot.bootcamp.controller.ProductController;
import com.api.rest.springboot.bootcamp.document.Product;
import com.api.rest.springboot.bootcamp.dto.ProductDto;
import com.api.rest.springboot.bootcamp.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
@WebFluxTest(ProductController.class)
class ApiRestSpringbootBootcampProductsApplicationTests {

	private WebTestClient webTestClient;

	@MockBean
	private ProductService productService;

	@Test
	void contextLoads() {
	}

	@Test
	public void getCustomersTest() {
		Flux<ProductDto> productDtoFlux = Flux.just(ProductDto.builder()
				.id(UUID.randomUUID().toString())
				.code("12345678")
				.productType("Cuenta Bancaria")
				.productName("Cuenta de ahorro")
				.description("Cuenta de ahorro personal")
				.build()
		);

		when(productService.getAllProducts()).thenReturn(productDtoFlux);

		Flux<ProductDto> responseBody = webTestClient.get().uri("/api/products")
				.exchange()
				.expectStatus().isOk()
				.returnResult(ProductDto.class)
				.getResponseBody();

		StepVerifier.create(responseBody)
				.expectSubscription()
				.expectNext(ProductDto.builder()
						.id(UUID.randomUUID().toString())
						.code("12345678")
						.productType("Cuenta Bancaria")
						.productName("Cuenta de ahorro")
						.description("Cuenta de ahorro de prueba")
						.build())
				.verifyComplete();

	}
	@Test
	public void createProduct() {
		Mono<ProductDto> productDtoMono = Mono.just(ProductDto.builder()
				.id(UUID.randomUUID().toString())
				.code("12345678")
				.productType("Cuenta Bancaria")
				.productName("Cuenta de ahorro")
				.description("Cuenta de ahorro de prueba")
				.build()
		);
		when(productService.saveProduct(productDtoMono)).thenReturn(productDtoMono);
		webTestClient.post().uri("/api/products")
				.body(Mono.just(productDtoMono)
						, ProductDto.class)
				.exchange()
				.expectStatus().isOk(); //200
	}

}
