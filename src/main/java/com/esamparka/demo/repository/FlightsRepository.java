package com.esamparka.demo.repository;

import com.esamparka.demo.entity.Markets;
import org.springframework.data.repository.CrudRepository;

public interface FlightsRepository extends CrudRepository<Markets, Integer> {

    //
}