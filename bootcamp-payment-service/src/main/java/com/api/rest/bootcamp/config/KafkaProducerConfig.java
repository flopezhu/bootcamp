package com.api.rest.bootcamp.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {
    /**
     * localhost test.
     */
    private final String bootstrapAddress = "localhost:9092";

    /*@Bean
    public ProducerFactory<String, Event<?>> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }
    @Bean
    public KafkaTemplate<String, Event<?>> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }*/
}
