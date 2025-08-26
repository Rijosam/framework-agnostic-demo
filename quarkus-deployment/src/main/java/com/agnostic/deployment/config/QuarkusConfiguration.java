package com.agnostic.deployment.config;

import com.agnostic.business.service.QuoteService;
import com.agnostic.business.service.QuoteServiceImpl;
import com.agnostic.database.repository.QuoteRepositoryImpl;
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
        return new QuoteServiceImpl(new QuoteRepositoryImpl(emf));
    }
}
