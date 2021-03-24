package com.esamparka.demo.repository;

import com.esamparka.demo.entity.Quotes;
import com.esamparka.demo.entity.QuotesList;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quotes, Integer> {
}
