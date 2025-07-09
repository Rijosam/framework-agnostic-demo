package com.devoxxpl.demo.controller;


import com.devoxxpl.business.model.QuoteDto;
import com.devoxxpl.business.service.QuoteService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/quote")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }


    @GET
    public QuoteDto getRandomQuote() {
        QuoteDto randomQuote = quoteService.getRandomQuote();
        if (randomQuote == null) {
            throw new RuntimeException("No quotes found in the database.");
        }
        return randomQuote;
    }
}
