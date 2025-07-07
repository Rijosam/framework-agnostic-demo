package com.agnostic.demo.repository;

import com.agnostic.demo.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}

