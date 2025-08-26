package com.agnostic.database.repository;


import com.agnostic.database.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
