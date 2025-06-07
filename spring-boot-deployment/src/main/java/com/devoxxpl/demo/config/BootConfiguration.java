package com.devoxxpl.demo.config;

import com.devoxxpl.business.service.QuoteService;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootConfiguration {
    @Bean
    public QuoteService quoteService(EntityManagerFactory emf) {
        return new QuoteService(emf);
    }
}
