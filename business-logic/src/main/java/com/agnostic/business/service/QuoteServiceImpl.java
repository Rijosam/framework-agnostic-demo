package com.agnostic.business.service;


import com.agnostic.business.model.QuoteDto;
import com.agnostic.database.entity.Quote;
import com.agnostic.database.repository.QuoteRepository;

import java.util.List;
import java.util.Random;

public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final Random random = new Random();

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public QuoteDto getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAllQuotes();
        if (quotes.isEmpty()) {
            return null;
        }
        int index = random.nextInt(quotes.size());
        Quote quote = quotes.get(index);
        return new QuoteDto(quote.getCharacter(), quote.getText());

    }
}

