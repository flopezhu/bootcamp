package com.api.rest.bootcamp.controller;

import com.api.rest.bootcamp.dto.ProductDto;
import com.api.rest.bootcamp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    /**
     * product service.
     */
    @Autowired
    private ProductService productService;

    /**
     * @return get all products.
     */
    @GetMapping
    public Mono<ResponseEntity<Flux<ProductDto>>> getAllProducts() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.getAllProducts()));
    }

    /**
     * @param id
     * @return get product for id.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductDto>> getProductForId(
            @PathVariable(name = "id") final String id) {
        return productService.getProductForId(id)
                .map(productDto -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(productDto));
    }

    /**
     * @param productDtoMono
     * @return save product.
     */
    @PostMapping("/register")
    public Mono<ResponseEntity<ProductDto>> registerProduct(
            @RequestBody final Mono<ProductDto> productDtoMono) {
        return productService.saveProduct(productDtoMono)
                .map(productDto -> ResponseEntity
                        .created(URI.create("/api/products"
                                .concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    /**
     * @param productDtoMono
     * @param id
     * @return update product for id.
     */
    @PutMapping("update/{id}")
    public Mono<ResponseEntity<ProductDto>> updateProductForId(
            @RequestBody final Mono<ProductDto> productDtoMono,
            @PathVariable(name = "id") final String id) {
        return productService.updateProductForId(productDtoMono, id)
                .map(productDto -> ResponseEntity
                        .created(URI.create("/api/product"
                                .concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    /**
     * @param id
     * @return delete product for id.
     */
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteProductForId(
            @PathVariable(name = "id") final String id) {
        return productService.deleteProductForId(id)
                .map(product -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(product));
    }
}
