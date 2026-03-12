package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public GreetingService greetingService() {
        return new GreetingService();
    }

    @Bean
    public GreetingPrinter greetingPrinter() {
        return new GreetingPrinter(greetingService());
    }
}