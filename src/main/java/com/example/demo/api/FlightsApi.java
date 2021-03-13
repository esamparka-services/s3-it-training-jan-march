package com.example.demo.api;

import com.example.demo.entity.Markets;
import com.example.demo.model.flights.MarketRequest;
import com.example.demo.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@RestController
public class FlightsApi {

    @Autowired
    FlightsRepository flightsRepository;

    @PostMapping("/insertMarket")
    public ResponseEntity<HttpStatus> insertMarket(@RequestBody MarketRequest marketRequest) {

        Markets markets = new Markets();
        markets.setCode(marketRequest.getCode());
        markets.setCountry(marketRequest.getCountry());

        flightsRepository.save(markets);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
