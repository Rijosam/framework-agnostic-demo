package com.devoxxpl.database.repository;


import com.devoxxpl.database.entity.Quote;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class QuarkusQuoteRepository implements QuoteRepository, PanacheRepository<Quote> {

    @Override
    public Quote saveQuote(Quote quote) {
        persist(quote);
        return quote;
    }

    @Override
    public Optional<Quote> findQuoteById(Long id) {
        return Optional.ofNullable(findById(id));
    }

    @Override
    public List<Quote> findAllQuote() {
        return listAll();
    }
}
