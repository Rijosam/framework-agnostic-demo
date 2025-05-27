package com.devoxxpl.demo.config;

import com.devoxxpl.demo.model.Quote;
import com.devoxxpl.demo.repository.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(QuoteRepository quoteRepository) {
        return args -> {
            quoteRepository.save(new Quote("They don’t know that we know they know we know.", "Phoebe"));
            quoteRepository.save(new Quote("Oh, I wish I could, but I don’t want to.", "Phoebe"));
            quoteRepository.save(new Quote("I don't even have a 'pla.", "Phoebe"));
            quoteRepository.save(new Quote("I’m not great at the advice. Can I interest you in a sarcastic comment?", "Chandler"));
            quoteRepository.save(new Quote("So it seems like this Internet thing’s here to stay.", "Chandler"));
            quoteRepository.save(new Quote("Hey, come on, I say more dumb things before 9 a.m. than most people say all day.", "Chandler"));
            quoteRepository.save(new Quote("Could I be wearing any more clothes?", "Joey"));
            quoteRepository.save(new Quote("You can’t just give up. Is that what a dinosaur would do?", "Joey"));
            quoteRepository.save(new Quote("How you doin'?", "Joey"));
            quoteRepository.save(new Quote("We were on a break!", "Ross"));
            quoteRepository.save(new Quote("I'm fine. Totally fine.", "Ross"));
            quoteRepository.save(new Quote("I grew up with Monica. If you didn't eat fast, you didn't eat.", "Ross"));
            quoteRepository.save(new Quote("Welcome to the real world. It sucks. You’re gonna love it.", "Monica"));
            quoteRepository.save(new Quote("I know!", "Monica"));
            quoteRepository.save(new Quote("Well, maybe I don’t need your money. Wait, wait, I said maybe!", "Rachel"));
            quoteRepository.save(new Quote("Oh I'm sorry. Did my back hurt your knife", "Rachel"));
        };
    }
}

