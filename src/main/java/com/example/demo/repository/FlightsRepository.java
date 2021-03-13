package com.example.demo.repository;

import com.example.demo.entity.Markets;
import org.springframework.data.repository.CrudRepository;

public interface FlightsRepository extends CrudRepository<Markets, Integer> {
}
