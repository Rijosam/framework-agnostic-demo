package com.agnostic.deployment.controller;

import com.agnostic.business.Quote;
import com.agnostic.business.QuoteService;
import com.agnostic.deployment.config.cloud.AzureKeyVaultManager;
import com.agnostic.deployment.config.cloud.Secret;
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
    public Quote getRandomQuote() {
        Quote randomQuote = quoteService.getRandomQuote();
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
