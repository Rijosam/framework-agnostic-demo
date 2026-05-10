package com.agnostic.database;

import com.agnostic.business.Quote;
import com.agnostic.business.QuoteProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Collections;
import java.util.List;

public class QuoteProviderImpl implements QuoteProvider {

    private final EntityManagerFactory entityManagerFactory;

    public QuoteProviderImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Quote> findAllQuotes() {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();

            List<Quote> quotes = em.createQuery("SELECT q FROM QuoteEntity q", QuoteEntity.class)
                    .getResultList()
                    .stream()
                    .map(this::mapQuoteEntity)
                    .toList();

            em.getTransaction().commit();
            return quotes;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private Quote mapQuoteEntity(QuoteEntity quoteEntity) {
        return new Quote(quoteEntity.getCharacter(), quoteEntity.getText());
    }
}

