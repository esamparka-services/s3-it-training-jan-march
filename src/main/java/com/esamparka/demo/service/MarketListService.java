package com.esamparka.demo.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.esamparka.demo.entity.Markets;
import com.esamparka.demo.repository.FlightsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public  class MarketListService {
@Autowired
    FlightsRepository flightsRepository;

    public List<Markets>  MarketList() throws Exception {
        Iterable<Markets> iterable =null;
        List<Map> list = null;
        List<Markets> listObjects = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");

        HttpEntity<Markets> httpEntity = new HttpEntity(headers);

        ResponseEntity<Map> response = restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US", HttpMethod.GET, httpEntity, Map.class);

        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Countries");

            //  System.out.println("List size is: " + list.size());
            for (Map item : list) {

                ModelMapper modelMapper = new ModelMapper();
                Markets myObject = modelMapper.map(item, Markets.class);
                listObjects.add(myObject);
            }
        }
        return listObjects;

    }


        }


