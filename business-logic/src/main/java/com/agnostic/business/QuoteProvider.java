package com.agnostic.business;

import java.util.List;

public interface QuoteProvider {
    List<Quote> findAllQuotes();
}
