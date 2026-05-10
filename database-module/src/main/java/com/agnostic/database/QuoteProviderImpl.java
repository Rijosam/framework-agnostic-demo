package com.agnostic.database;

import com.agnostic.business.Quote;
import com.agnostic.business.QuoteProvider;

import java.util.List;

public class QuoteProviderImpl implements QuoteProvider {

    private final QuoteRepository quoteRepository;

    public QuoteProviderImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public List<Quote> findAllQuotes() {
        return quoteRepository.findAll()
                .stream()
                .map(this::mapQuoteEntity)
                .toList();
    }
    private Quote mapQuoteEntity(QuoteEntity quoteEntity) {
        return new Quote(quoteEntity.getCharacter(), quoteEntity.getText());
    }
}

