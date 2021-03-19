package com.Database.demo.api;

import com.Database.demo.Entity.Markets;
import com.Database.demo.ModelFlights.MarketRequest;
import com.Database.demo.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightsApi {

    @Autowired
    FlightRepository flightRepository;


    @PostMapping("/insertMarket")
    public ResponseEntity<HttpStatus> insertMarket(@RequestBody MarketRequest marketRequest){

        Markets markets = new Markets();
        markets.setCode(marketRequest.getCode());
        markets.setCountry(marketRequest.getCountry());

        flightRepository.save(markets);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
