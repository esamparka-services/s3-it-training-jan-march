package com.example.demo.Service;

import com.example.demo.entity.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CurrenciesService {

    public List<Currencies> CurrencyService() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "4540b3b8cdmsh9558f08255fd45ep1f2c95jsn600835c99fbb");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/currencies", HttpMethod.GET, httpEntity, Map.class);
        System.out.println(response);
        List<Map> list = null;
        List<Currencies> listObjects = new ArrayList<>();

        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Currencies");

            for (Map item : list) {

                ModelMapper modelMapper = new ModelMapper();
                Currencies currencies = modelMapper.map(item, Currencies.class);
                Currencies myObject = currencies;


                listObjects.add(myObject);
            }

        }
        return listObjects;
    }
}