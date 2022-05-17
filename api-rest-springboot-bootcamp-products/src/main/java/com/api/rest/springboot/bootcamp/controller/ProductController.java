package com.api.rest.springboot.bootcamp.controller;

import com.api.rest.springboot.bootcamp.document.Product;
import com.api.rest.springboot.bootcamp.dto.ProductDto;
import com.api.rest.springboot.bootcamp.service.ProductService;
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

    @Autowired
    private ProductService productService;

    @GetMapping
    public Mono<ResponseEntity<Flux<ProductDto>>> getAllProducts() {
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productService.getAllProducts()));
        //return productService.getAllProducts().map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ProductDto>> getProductForId(@PathVariable(name = "id") String id) {
        return productService.getProductForId(id).map(productDto -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(productDto));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<ProductDto>> registerProduct(@RequestBody Mono<ProductDto> productDtoMono) {
        return productService.saveProduct(productDtoMono).map(productDto -> ResponseEntity.created(URI.create("/api/products".concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    @PutMapping("update/{id}")
    public Mono<ResponseEntity<ProductDto>> updateProduct(@RequestBody Mono<ProductDto> productDtoMono, @PathVariable(name = "id") String id) {
        return productService.updateProductForId(productDtoMono, id).map(productDto -> ResponseEntity.created(URI.create("/api/product".concat(productDto.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(productDto));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteProduct(@PathVariable(name = "id") String id) {
        return productService.deleteProductForId(id).map(product -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(product));
    }

}
