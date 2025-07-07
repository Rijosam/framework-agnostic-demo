package com.agnostic.database.repository;


import com.agnostic.database.entity.Quote;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpringQuoteRepository extends JpaRepository<Quote, Long>, QuoteRepository {

    @Override
    @Query("SELECT q FROM Quote q")
    List<Quote> findAllQuotes();

    @Query("SELECT q FROM Quote q WHERE q.id = :id")
    Optional<Quote> findQuoteById(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query(
            value = "INSERT INTO quote (text, character) VALUES (:text, :character)",
            nativeQuery = true
    )
    int insertQuote(@Param("text") String text, @Param("character") String character);

    @Override
    default void saveQuote(Quote quote) {
        insertQuote(quote.getText(), quote.getCharacter());
    }


}
