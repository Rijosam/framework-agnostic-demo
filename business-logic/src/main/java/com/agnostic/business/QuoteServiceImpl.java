package com.agnostic.business;


import java.util.List;
import java.util.Random;

public class QuoteServiceImpl implements QuoteService {

    private final QuoteProvider quoteProvider;
    private final Random random = new Random();

    public QuoteServiceImpl(QuoteProvider quoteProvider) {
        this.quoteProvider = quoteProvider;
    }

    @Override
    public Quote getRandomQuote() {

        List<Quote> quotes = quoteProvider.findAllQuotes();
        if (quotes.isEmpty()) {
            return null;
        }
        int index = random.nextInt(quotes.size());
        return quotes.get(index);
    }
}

