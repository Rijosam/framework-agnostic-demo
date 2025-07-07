package com.agnostic.demo.config;

import com.agnostic.business.service.QuoteService;
import com.agnostic.business.service.QuoteServiceImpl;
import com.agnostic.database.repository.QuoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootConfiguration {

    @Bean
    public QuoteService quoteService(QuoteRepository quoteRepository) {
        return new QuoteServiceImpl(quoteRepository);
    }
}
