package com.esamparka.demo;

import com.esamparka.demo.entity.Quotes;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    @Test
    public void Print()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        //= restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET, httpEntity, Map.class);
        ResponseEntity<Map> response =restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET, httpEntity, Map.class);
        System.out.println(response.getBody());
    }
}
