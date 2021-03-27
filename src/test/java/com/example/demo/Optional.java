package com.example.demo;


import com.example.demo.model.flights.QuoteList;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Optional {


    @Test
    public void givenOptional_whenMapWorks_thenCorrect() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        System.out.println("original list: " + numbers);

        List<Integer> even = numbers.stream()
                .map(Integer::valueOf)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("processed list, only even numbers: " + even);

    }

    @Test
    public void testQuotesApi(){
        //convert your http client to restTemplate
        String api = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers  = new HttpHeaders();;
        headers.set("x-rapidapi-key", "238bf338d4mshe304ac92aba0296p15389djsn1021ce25e2de");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<QuoteList> response = restTemplate.exchange(api,HttpMethod.GET,httpEntity, QuoteList.class);
        System.out.println(response);
    }
}
