package com.agnostic.database.repository;


import com.agnostic.database.entity.Quote;

import java.util.List;
import java.util.Optional;


public interface QuoteRepository {
    void saveQuote(Quote quote);
    Optional<Quote> findQuoteById(Long id);
    List<Quote> findAllQuotes();
}
