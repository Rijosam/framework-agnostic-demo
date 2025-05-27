package com.devoxxpl.demo.repository;

import com.devoxxpl.demo.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}

