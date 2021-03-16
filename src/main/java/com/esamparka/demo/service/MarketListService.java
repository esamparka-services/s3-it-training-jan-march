package com.esamparka.demo.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

@Service
public  class MarketListService {


    public String  MarketList() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US"))
                .header("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209")
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send((HttpRequest) request, HttpResponse.BodyHandlers.ofString());


       String jsonString = response.body();
return jsonString;


        }

}
