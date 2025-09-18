package com.agnostic.deployment.controller;

import com.agnostic.business.model.QuoteDto;
import com.agnostic.business.service.QuoteService;
import com.agnostic.deployment.config.cloud.AzureKeyVaultManager;
import com.agnostic.deployment.config.cloud.Secret;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class QuoteController {

    private final QuoteService quoteService;
    private final AzureKeyVaultManager azureKeyVaultManager;

    @Inject
    public QuoteController(QuoteService quoteService, AzureKeyVaultManager azureKeyVaultManager) {
        this.quoteService = quoteService;
        this.azureKeyVaultManager = azureKeyVaultManager;
    }

    @GET
    @Path("/quote")
    public QuoteDto getRandomQuote() {
        QuoteDto randomQuote = quoteService.getRandomQuote();
        if (randomQuote == null) {
            throw new RuntimeException("No quotes found in the database.");
        }
        return randomQuote;
    }

    @GET
    @Path("/secret")
    public Secret getSecretFromCloud(){
        return azureKeyVaultManager.getSecret();
    }

}
