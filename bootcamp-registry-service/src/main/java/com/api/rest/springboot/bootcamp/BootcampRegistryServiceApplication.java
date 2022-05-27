package com.api.rest.springboot.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootcampRegistryServiceApplication {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BootcampRegistryServiceApplication.class, args);
    }

}
