package com.devoxxpl.database.repository;


import com.devoxxpl.database.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringQuoteRepository extends JpaRepository<Quote, Long>, QuoteRepository {
}
