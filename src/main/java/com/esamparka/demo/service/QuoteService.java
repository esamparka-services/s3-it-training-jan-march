package com.esamparka.demo.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class QuoteService {
    public String TQuoteService() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsedates/v1.0/US/USD/en-US/SFO-sky/LAX-sky/2021-04-16?inboundpartialdate=2021-04-16"))
                .header("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209")
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        String jsonString = response.body();

        return jsonString;
    }
}