package com.api.rest.bootcamp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.api.rest.bootcamp.repository")
@EnableMongoAuditing
public class MongoReactive {
}
