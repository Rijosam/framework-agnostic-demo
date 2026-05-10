package com.agnostic.deployment.config;

import com.agnostic.business.QuoteService;
import com.agnostic.business.QuoteServiceImpl;
import com.agnostic.database.QuoteProviderImpl;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootConfiguration {

    @Bean
    public QuoteService quoteService(EntityManagerFactory entityManagerFactory) {
        return new QuoteServiceImpl(new QuoteProviderImpl(entityManagerFactory));
    }
}
