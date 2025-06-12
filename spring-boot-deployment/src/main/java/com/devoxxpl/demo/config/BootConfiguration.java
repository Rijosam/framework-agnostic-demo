package com.devoxxpl.demo.config;

import com.devoxxpl.business.service.QuoteService;
import com.devoxxpl.business.service.QuoteServiceImpl;
import com.devoxxpl.database.repository.QuoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootConfiguration {

    @Bean
    public QuoteService quoteService(QuoteRepository quoteRepository) {
        return new QuoteServiceImpl(quoteRepository);
    }
}
