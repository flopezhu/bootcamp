package com.api.rest.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BootcampTransactionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampTransactionServiceApplication.class, args);
	}

}
