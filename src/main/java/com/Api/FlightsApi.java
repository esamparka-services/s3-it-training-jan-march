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

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;



@RestController
public class FlightsApi {
    @Autowired
    FlightsRepository flightsRepository;


    @PostMapping("/addData")

    public ResponseEntity<HttpStatus> addCOntent(@RequestBody MarketRequest marketRequest) {
        Markets market = new Markets();

        market.setCode(marketRequest.getCode());
        market.setName(marketRequest.getName());
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

    public ResponseEntity<HttpStatus> updateRecord(@RequestBody Markets markets, @RequestParam String code, @RequestParam String name) {

        ResponseEntity<HttpStatus> rE;

        if (flightsRepository.existsById(markets.getId())) {
            markets.setCode(code);
            markets.setName(name);
            flightsRepository.save(markets);
            rE = new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            System.out.println("Invalid request/No data available");
            rE = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return rE;

    }

    @PostMapping("/displayCountry")
    public void displayCountry() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US"))
                .header("x-rapidapi-key", "4540b3b8cdmsh9558f08255fd45ep1f2c95jsn600835c99fbb")
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        String resp = response.body();
        JSONObject obj = new JSONObject(resp);
        JSONArray arr = obj.getJSONArray("Countries");
        for (int i = 0; i < arr.length(); i++) {
            Markets markets = new Markets();
            String Code = arr.getJSONObject(i).getString("Code");
            String Name = arr.getJSONObject(i).getString("Name");
            markets.setCode(Code);
            markets.setName(Name);
            System.out.println(Code);
            flightsRepository.save(markets);


        }


    }
}

