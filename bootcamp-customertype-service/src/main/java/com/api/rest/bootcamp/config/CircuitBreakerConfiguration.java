package com.api.rest.bootcamp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfiguration {
    /**
     * LOG for CircuitBreakerConfiguration.class.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(CircuitBreakerConfiguration.class);

    /**
     * @return circuit breaker factory.
     */
   /* @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory>
    slowCustomizer() {
        return factory -> {
            factory.configure(builder -> builder
                            .timeLimiterConfig(TimeLimiterConfig.custom()
                                    .timeoutDuration(Duration.ofSeconds(2))
                                    .build())
                            .circuitBreakerConfig(CircuitBreakerConfig
                                    .ofDefaults()),
                    "test1", "test2");
            factory.addCircuitBreakerCustomizer(circuitBreaker ->
                    circuitBreaker.getEventPublisher()
                            .onError(error -> {
                                LOG.error("bug found in circuit breaker:{}",
                                        error.getThrowable().getMessage());
                            }).onSuccess(success -> {
                                LOG.info("circuit breaker  success:{}",
                                        success.getCircuitBreakerName());
                            }));
        };
    }*/
}
