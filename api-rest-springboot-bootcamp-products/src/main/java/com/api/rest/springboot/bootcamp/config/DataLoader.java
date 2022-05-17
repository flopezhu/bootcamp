package com.api.rest.springboot.bootcamp.config;

import com.api.rest.springboot.bootcamp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ProductService productService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
