package com.agnostic.demo.controller;

import com.agnostic.demo.config.AzureKeyVaultManager;
import com.agnostic.demo.config.Secret;
import com.agnostic.demo.model.Quote;
import com.agnostic.demo.model.QuoteDto;
import com.agnostic.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    private final QuoteService quoteService;
    private final AzureKeyVaultManager azureKeyVaultManager;

    @Autowired
    public QuoteController(QuoteService quoteService, AzureKeyVaultManager azureKeyVaultManager) {
        this.quoteService = quoteService;
        this.azureKeyVaultManager = azureKeyVaultManager;
    }

    @GetMapping("/quote")
    public QuoteDto getRandomQuote() {
        QuoteDto randomQuote = quoteService.getRandomQuote();
        if (randomQuote == null) {
            throw new RuntimeException("No quotes found in the database.");
        }
        return randomQuote;
    }

    @GetMapping("/secret")
    public Secret getSecretFromCloud(){
       return azureKeyVaultManager.getSecret();
    }
}
