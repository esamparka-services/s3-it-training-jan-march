package com.esamparka.demo;

import com.esamparka.demo.entity.*;
import com.esamparka.demo.model.flights.MarketRequest;
import com.esamparka.demo.model.flights.MarketsList;
import com.esamparka.demo.repository.FlightsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.*;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@RestController
public class Checker implements Serializable {


    @Test
    public void RestImplementation() {

        List<Map> list = null;
        List<Quotes> listObjects = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET, httpEntity, String.class);
        System.out.println(response.getBody());


    }






    }





    //    @Test
//    public void RestImplementation() {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
//        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
//        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
//        ResponseEntity<String> responseEntity = restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET,httpEntity,String.class);
//        System.out.println(responseEntity.getBody());
//    }

//
//    @Test
//    public void RestImplementation() {
//
//
//        List<Map> list = null;
//        List<Markets> listObjects = new ArrayList<>();
//
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        RestTemplate restTemplate = new RestTemplate();
//        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
//        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
//
//        HttpEntity<Markets> httpEntity = new HttpEntity(headers);
//
//        ResponseEntity<Map> response = restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US", HttpMethod.GET, httpEntity, Map.class);
//
//        if (response != null && response.getStatusCode().value() == 200) {
//            list = (List<Map>) response.getBody().get("Countries");
//
//            System.out.println("List size is: " + list.size());
//
////            for (Map a: list)
////            {
////                System.out.println(a.toString());
////            }
//
//
//            for (Map item : list) {
//                Markets myObject = transform(item);
////flightsRepository.save(myObject);
//
//                listObjects.add(myObject);
//            }
//
////         Iterable<Markets> iterable2 = listObjects;
////          flightsRepository.saveAll(iterable2);
//
//            System.out.println(listObjects.toString());
//        }
//
//    }
//
//    private Markets transform(Map item) {
//        ModelMapper modelMapper = new ModelMapper();
//        Markets marketRequest = modelMapper.map(item, Markets.class);
//        return marketRequest;
//    }
