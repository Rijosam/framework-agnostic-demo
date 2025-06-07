package com.devoxxpl.demo.config;

import com.devoxxpl.business.service.QuoteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManagerFactory;

public class QuarkusConfiguration {
    @Inject
    EntityManagerFactory emf;

    @Produces
    @ApplicationScoped
    public QuoteService quoteService() {
        return new QuoteService(emf);
    }
}
