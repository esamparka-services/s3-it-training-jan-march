package com.esamparka.demo;

import com.esamparka.demo.entity.Currencies;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyChecker {

@Test
    public void RestImplementation() {

        List<Map> list = null;
        List<Currencies> listObjects = new ArrayList<>();
        Iterable<Currencies> iterable2 =null;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        HttpEntity<Currencies> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET, httpEntity, Map.class);
        //System.out.println(responseEntity.getBody());


        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Currencies");

             System.out.println("List size is: " + list.size());

            for (Map a: list)
            {
                System.out.println(a.toString());
            }


            for (Map item : list) {
                Currencies myObject = transform(item);
                // flightsRepository.save(myObject);

                listObjects.add(myObject);
            }

            iterable2 = listObjects;

        }

    System.out.println(iterable2.toString());

    }

    private Currencies transform(Map item) {
        ModelMapper modelMapper = new ModelMapper();
        Currencies marketRequest = modelMapper.map(item, Currencies.class);
        return marketRequest;
    }
}
