package com.api.rest.gateway.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BootcampGatewayServiceApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BootcampGatewayServiceApplication.class, args);
    }

}
