package com.api.rest.bootcamp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class BootcampCustomerServiceApplication {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BootcampCustomerServiceApplication.class, args);
    }

}
