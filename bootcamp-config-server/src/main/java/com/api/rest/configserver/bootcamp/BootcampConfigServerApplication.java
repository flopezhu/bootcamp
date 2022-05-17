package com.api.rest.configserver.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootcampConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootcampConfigServerApplication.class, args);
    }

}
