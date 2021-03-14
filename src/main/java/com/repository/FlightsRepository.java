package com.repository;
//Wrapper Eg: Integer, Double  (Integer.parseInt
import com.entity.Markets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface FlightsRepository extends CrudRepository<Markets,Integer> {



}
