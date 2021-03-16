package com.esamparka.demo.repository;

import com.esamparka.demo.entity.Currencies;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currencies,String> {
}
