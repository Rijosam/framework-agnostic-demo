package com.devoxxpl.database.repository;


import com.devoxxpl.database.entity.Quote;

import java.util.List;
import java.util.Optional;


public interface QuoteRepository {
    void saveQuote(Quote quote);
    Optional<Quote> findQuoteById(Long id);
    List<Quote> findAllQuotes();
}
