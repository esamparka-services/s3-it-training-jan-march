package com.example.demo.repository;

import com.example.demo.entity.Currencies;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Currencies,Integer> {
}
