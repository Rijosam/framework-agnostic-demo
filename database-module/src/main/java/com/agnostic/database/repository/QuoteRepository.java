package com.agnostic.database.repository;

import com.agnostic.database.entity.Quote;

import java.util.List;

public interface QuoteRepository {
    void saveQuote(Quote quote);
    List<Quote> findAll();
}
