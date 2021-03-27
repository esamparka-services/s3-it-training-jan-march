package com.esamparka.demo;

import com.esamparka.demo.entity.Currencies;
import com.esamparka.demo.entity.OutboundLeg;
import com.esamparka.demo.entity.Quotes;
import com.esamparka.demo.service.QuoteGetResponseBodyService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QuoteCheckerOutBoundLeg {
   @Autowired
    QuoteGetResponseBodyService quoteGetResponseBodyService;

    @Test

    public void QuotesService() throws Exception {
        List<Map> list = null;
        List<Quotes> listObjects = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        HttpEntity<Currencies> httpEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response  =restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET, httpEntity, Map.class);

        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Quotes");

            for (Map item : list) {

                ModelMapper modelMapper = new ModelMapper();
                Quotes carriers = modelMapper.map(item, Quotes.class);
                LinkedHashMap outboundLegMap = (LinkedHashMap) item.get("OutboundLeg");
                Map convertedMap = outboundLegMap;
                String  s = convertedMap.toString();
                ArrayList<Integer> CarriedIDMap  = (ArrayList<Integer>) convertedMap.get("CarrierIds");
                System.out.println(CarriedIDMap.toString());

               // System.out.println(s1);
               // System.out.println("======");
                //carriers.setOutboundLegJSON(s);
                OutboundLeg outboundLeg = modelMapper.map(convertedMap, OutboundLeg.class);
               // System.out.println(outboundLeg.getDepartureDate());



            }



        }



    }
}
