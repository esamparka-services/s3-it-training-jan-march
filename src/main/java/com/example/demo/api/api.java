package com.example.demo.api;


import com.example.demo.entity.Markets;
import com.example.demo.repository.FlightsRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@RestController
public class api {

    @Bean
    public void testBean() throws IOException, InterruptedException {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US"))
//                .header("x-rapidapi-key", "c525e6d241msha8ea76e477352a9p142a67jsn4595640112d1")
//                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
    }
    @Autowired
    FlightsRepository flightsRepository;
@PostMapping("/insertCountry")
    public void insertCountry() throws Exception{
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US"))
            .header("x-rapidapi-key", "c525e6d241msha8ea76e477352a9p142a67jsn4595640112d1")
            .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
   // System.out.println(response.body());
    String a =response.body();
    JSONObject object = new JSONObject(a);
    JSONArray arr = object.getJSONArray("Countries");
    for (int i = 0; i < arr.length(); i++) {
        Markets markets = new Markets();
        String Code = arr.getJSONObject(i).getString("Code");
        String Name = arr.getJSONObject(i).getString("Name");
        markets.setCode(Code);
        markets.setName(Name);
       // System.out.println("Code" + Code   +  "Name " + Name);
        flightsRepository.save(markets);
    }

    }

}



