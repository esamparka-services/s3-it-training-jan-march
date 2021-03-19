package com.Database.demo.Repository;

import com.Database.demo.Entity.Markets;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Markets, Integer> {


}
