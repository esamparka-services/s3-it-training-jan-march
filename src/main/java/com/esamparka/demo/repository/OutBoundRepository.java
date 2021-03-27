package com.esamparka.demo.repository;

import com.esamparka.demo.entity.OutboundLeg;
import org.springframework.data.repository.CrudRepository;

public interface OutBoundRepository  extends CrudRepository<OutboundLeg,Integer> {
}
