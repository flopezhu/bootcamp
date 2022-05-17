package com.api.rest.springboot.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiRestSpringbootBootcampProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestSpringbootBootcampProductsApplication.class, args);
    }
}
