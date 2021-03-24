package com.esamparka.demo.service;

import com.esamparka.demo.entity.Currencies;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class QuoteGetResponseBodyService {

    public ResponseEntity<Map> getResponseBody()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        HttpEntity<Currencies> httpEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<Map> response = restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET, httpEntity, Map.class);
        return restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET, httpEntity, Map.class);


    }
}