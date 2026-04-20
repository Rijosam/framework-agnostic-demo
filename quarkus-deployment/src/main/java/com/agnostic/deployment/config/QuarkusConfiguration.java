package com.agnostic.deployment.config;

import com.agnostic.business.service.QuoteService;
import com.agnostic.business.service.QuoteServiceImpl;
import com.agnostic.database.repository.QuoteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.Produces;


public class QuarkusConfiguration {

    @Produces
    @ApplicationScoped
    public QuoteService quoteService(EntityManagerFactory emf) {
        return new QuoteServiceImpl(new QuoteRepositoryImpl(emf));
    }
}
