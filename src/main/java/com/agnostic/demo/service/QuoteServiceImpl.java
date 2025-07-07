package com.agnostic.demo.service;

import com.agnostic.demo.model.Quote;
import com.agnostic.demo.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final Random random = new Random();

    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.isEmpty()) {
            return null;
        }
        int index = random.nextInt(quotes.size());
        return quotes.get(index);
    }
}

