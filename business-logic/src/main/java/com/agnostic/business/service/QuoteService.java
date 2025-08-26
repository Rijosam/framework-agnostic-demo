package com.agnostic.business.service;


import com.agnostic.business.model.QuoteDto;
import com.agnostic.database.entity.Quote;
import com.agnostic.database.repository.QuoteRepository;

import java.util.List;
import java.util.Random;

public class QuoteService  {

    private final QuoteRepository repository;
    private final Random random = new Random();

    public QuoteService(QuoteRepository repository) {
        this.repository = repository;
    }

    public QuoteDto getRandomQuote() {
        List<Quote> quotes = repository.findAllQuotes();
        if (quotes.isEmpty()) {
            return null;
        }
        int index = random.nextInt(quotes.size());
        Quote quote = quotes.get(index);
        return new QuoteDto(quote.getCharacter(), quote.getText());
    }
}

