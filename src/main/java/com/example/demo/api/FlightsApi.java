package com.example.demo.api;

import com.example.demo.entity.Markets;
import com.example.demo.flights.MarketRequest;
import com.example.demo.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightsApi {
    @Autowired
    FlightsRepository flightsRepository;
    @PostMapping("/insertMarket")
    public ResponseEntity<HttpStatus> insertMarket(@RequestBody MarketRequest marketRequest) {

        Markets markets = new Markets();
        markets.setCode(marketRequest.getCode());
        markets.setName(marketRequest.getCountry());

        flightsRepository.save(markets);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/updateTable")
    public ResponseEntity<HttpStatus> updateTable (@RequestBody Markets markets, @RequestParam String code, @RequestParam String country) {

        ResponseEntity<HttpStatus> responseEntity;
        if (flightsRepository.existsById(markets.getId())) {
            markets.setCode(code);
            markets.setName(country);
            flightsRepository.save(markets);
            responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
       }
        else {
            System.out.println("UnSupportive Data Given !!");
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;

    }

}



