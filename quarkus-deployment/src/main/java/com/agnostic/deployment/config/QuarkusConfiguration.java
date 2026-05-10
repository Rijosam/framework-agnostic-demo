package com.agnostic.deployment.config;

import com.agnostic.business.QuoteService;
import com.agnostic.business.QuoteServiceImpl;
import com.agnostic.database.QuoteProviderImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.Produces;

public class QuarkusConfiguration {

    @Produces
    @ApplicationScoped
    public QuoteService quoteService(EntityManagerFactory entityManagerFactory) {
        return new QuoteServiceImpl(new QuoteProviderImpl(entityManagerFactory));
    }
}
