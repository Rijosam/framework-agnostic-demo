package com.agnostic.database.repository;


import com.agnostic.database.entity.Quote;
import jakarta.persistence.EntityManager;

import java.util.List;

public class QuoteRepository {

    private final EntityManager entityManager;

    public QuoteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveQuote(Quote quote) {
        entityManager.persist(quote);
    }

    public List<Quote> findAllQuotes() {
        return entityManager.createQuery("SELECT q FROM Quote q", Quote.class)
                .getResultList();
    }
}
