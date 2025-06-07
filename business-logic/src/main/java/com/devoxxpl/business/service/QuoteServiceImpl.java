package com.devoxxpl.business.service;


import com.devoxxpl.business.model.QuoteDto;
import com.devoxxpl.database.entity.Quote;
import com.devoxxpl.database.repository.QuoteRepository;
import jakarta.inject.Named;

import java.util.List;
import java.util.Random;

@Named
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final Random random = new Random();

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public QuoteDto getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.isEmpty()) {
            return null;
        }
        int index = random.nextInt(quotes.size());
        Quote quote = quotes.get(index);
        return new QuoteDto(quote.getCharacter(), quote.getText());

    }
}

