package com.agnostic.database.repository;


import com.agnostic.database.entity.Quote;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collections;
import java.util.List;

public class QuoteRepositoryImpl implements QuoteRepository {

    private final EntityManagerFactory emf;

    public QuoteRepositoryImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void saveQuote(Quote quote) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(quote);
            em.getTransaction().commit();
        }
    }

    @Override
    public List<Quote> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            List<Quote> quotes = em.createQuery("SELECT q FROM Quote q", Quote.class)
                    .getResultList();
            em.getTransaction().commit();
            return quotes;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
