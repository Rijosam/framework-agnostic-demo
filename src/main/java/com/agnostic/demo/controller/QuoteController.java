package com.agnostic.demo.controller;

import com.agnostic.demo.model.Quote;
import com.agnostic.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping("/quote")
    public Quote getRandomQuote() {
        Quote randomQuote = quoteService.getRandomQuote();
        if (randomQuote == null) {
            throw new RuntimeException("No quotes found in the database.");
        }
        return randomQuote;
    }
}
