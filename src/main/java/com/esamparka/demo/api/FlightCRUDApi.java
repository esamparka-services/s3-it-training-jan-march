package com.esamparka.demo.api;

import com.esamparka.demo.entity.Markets;
import com.esamparka.demo.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightCRUDApi {
    @Autowired
    FlightsRepository flightsRepository;

    @PostMapping("/insertMarket")
    public ResponseEntity<HttpStatus> insertMarket(@RequestParam String code, @RequestParam String Name) {

        Markets markets = new Markets();
        markets.setName(Name);
        markets.setCode(code);
        //markets.setCode(marketRequest.getCode());
        //markets.setCountry(marketRequest.getCountry());

        flightsRepository.save(markets);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping("/deleteMarket")
    public ResponseEntity<HttpStatus> deleteMarket(@RequestParam int id) {
        ResponseEntity<HttpStatus> rE;

        if (flightsRepository.existsById(id)) {
            flightsRepository.deleteById(id);
            rE = new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            System.out.println("No id in the databse");
            rE = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return rE;
    }

    @PostMapping("/updateMarket")
    public ResponseEntity<HttpStatus> deleteMarket(@RequestBody Markets markets, @RequestParam String code, @RequestParam String Name ) {
        ResponseEntity<HttpStatus> rE;


        if (flightsRepository.existsById(markets.getId())) {
            markets.setCode(code);
            markets.setName(Name);
            flightsRepository.save(markets);
            rE = new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            System.out.println("No id in the databse");
            rE = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return rE;
    }
}
