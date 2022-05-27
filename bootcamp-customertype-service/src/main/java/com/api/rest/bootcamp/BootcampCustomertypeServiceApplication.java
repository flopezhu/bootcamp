package com.api.rest.bootcamp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class BootcampCustomertypeServiceApplication {
    /**
     * @return object mapping.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(BootcampCustomertypeServiceApplication.class, args);
    }

}
