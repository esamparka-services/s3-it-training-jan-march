package com.esamparka.demo.repository;

import com.esamparka.demo.entity.Places;
import org.springframework.data.repository.CrudRepository;

public interface PlacesRepository extends CrudRepository<Places, Integer> {
}
