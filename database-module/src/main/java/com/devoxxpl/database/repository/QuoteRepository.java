package com.devoxxpl.database.repository;


import com.devoxxpl.database.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuoteRepository {
    Quote save(Quote quote);
    Optional<Quote> findById(Long id);
    List<Quote> findAll();
}
