package com.agnostic.deployment.config;

import com.agnostic.business.service.QuoteService;
import com.agnostic.database.repository.QuoteRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootConfiguration {
    @Bean
    public QuoteService quoteService(EntityManagerFactory emf) {
        return new QuoteService(new QuoteRepository(emf));
    }
}
