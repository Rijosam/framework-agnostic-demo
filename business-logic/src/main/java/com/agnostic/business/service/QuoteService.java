package com.agnostic.business.service;


import com.agnostic.business.model.QuoteDto;
import com.agnostic.database.entity.Quote;
import com.agnostic.database.repository.QuoteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Random;

public class QuoteService  {

    private final EntityManagerFactory emf;
    private final Random random = new Random();

    public QuoteService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public QuoteDto getRandomQuote() {

        try(EntityManager em = emf.createEntityManager()){
            QuoteRepository repository = new QuoteRepository(em);
            em.getTransaction().begin();
            List<Quote> quotes = repository.findAllQuotes();
            if (quotes.isEmpty()) {
                return null;
            }
            int index = random.nextInt(quotes.size());
            Quote quote = quotes.get(index);
            em.getTransaction().commit();
            return new QuoteDto(quote.getCharacter(), quote.getText());
        }
        catch (Exception e){
            return null;
        }

    }
}

