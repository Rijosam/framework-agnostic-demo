package com.agnostic.deployment.config;

import com.agnostic.business.QuoteService;
import com.agnostic.business.QuoteServiceImpl;
import com.agnostic.database.QuoteProviderImpl;
import com.agnostic.database.QuoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootConfiguration {

    @Bean
    public QuoteService quoteService(QuoteRepository quoteRepository) {
        return new QuoteServiceImpl(new QuoteProviderImpl(quoteRepository));
    }
}
