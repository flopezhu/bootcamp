package com.api.rest.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BootcampCustomerServiceApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BootcampCustomerServiceApplication.class, args);
    }

}
