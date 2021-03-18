package com.Api;

import com.entity.Markets;
import com.module.flights.MarketRequest;
import com.repository.FlightsRepository;
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


    @PostMapping("/addData")

    public ResponseEntity<HttpStatus> addCOntent(@RequestBody MarketRequest marketRequest) {
        Markets market = new Markets();

        market.setCode(marketRequest.getCode());
        market.setCountry(marketRequest.getCountry());
        flightsRepository.save(market);


        ResponseEntity<HttpStatus> rs = new ResponseEntity<>(HttpStatus.CONTINUE);
        System.out.println(HttpStatus.CONTINUE + " " + HttpStatus.CHECKPOINT);
        return rs;

    }

    @PostMapping("/deleteRecord")

    public ResponseEntity<HttpStatus> deleteRecord(@RequestParam int id) {
        ResponseEntity<HttpStatus> rE;
        if (flightsRepository.existsById(id)) {
            flightsRepository.deleteById(id);
            rE = new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            System.out.println("Invalid request/No data available");
            rE = new ResponseEntity<>(HttpStatus.CREATED);
        }
        return rE;


    }

    @PostMapping("/updateRecord")

    public ResponseEntity<HttpStatus> updateRecord(@RequestBody Markets markets,@RequestParam String code,@RequestParam String country) {

        ResponseEntity<HttpStatus> rE;

        if (flightsRepository.existsById(markets.getId())){
            markets.setCode(code);
            markets.setCountry(country);
            flightsRepository.save(markets);
            rE = new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            System.out.println("Invalid request/No data available");
            rE = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return rE;

    }
}
