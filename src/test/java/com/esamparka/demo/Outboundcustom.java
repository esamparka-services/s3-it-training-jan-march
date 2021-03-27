package com.esamparka.demo;

import com.esamparka.demo.entity.CarrierId;
import com.esamparka.demo.entity.OutboundLeg;
import com.esamparka.demo.entity.Quotes;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Outboundcustom {

    @Test
    public void QuotesService() {
        List<Map> list = null;
        List<Quotes> quotesList = new ArrayList<>();
        List<OutboundLeg> outboundLegList =new ArrayList<>();
        List<CarrierId> carrierIdList = new ArrayList<>();

        List<Map> outBoundlist = null;
        List<OutboundLeg> outboundLegListObject = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "82bd4dde56msh28191fe62be6478p1c002ejsn3365ddee9209");
        headers.set("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/US/USD/en-US/SFO-sky/JFK-sky/anytime?inboundpartialdate=anytime", HttpMethod.GET, httpEntity, Map.class);


        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Quotes");

            for (Map item : list) {

                ModelMapper modelMapper = new ModelMapper();
             //   modelMapper.getConfiguration().setAmbiguityIgnored(true);
               // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
                Quotes carriers = modelMapper.map(item, Quotes.class);
                LinkedHashMap outboundLegMap = (LinkedHashMap) item.get("OutboundLeg");
                Map convertedMap = outboundLegMap;
                String  outboundLegString = convertedMap.toString();
                carriers.setOutboundLegJSON(outboundLegString);
                Quotes quotes = carriers;

                System.out.println(convertedMap);
                System.out.println(convertedMap.size());

                OutboundLeg outboundLeg = modelMapper.map(convertedMap, OutboundLeg.class);
                outboundLegList.add(outboundLeg);

                    List<Integer> CarriedIDMap  = (List<Integer>) convertedMap.get("CarrierIds");
                    for(Integer m: CarriedIDMap) {
                        System.out.println(m);
                        // System.out.println("Check point 2");
                        CarrierId carrierId = new CarrierId();
                        carrierId.setCarrierId(m);


                        carrierIdList.add(carrierId);
                    }
                System.out.println("Next round");
                   outboundLeg.setCarrierId(carrierIdList);
                // outBoundRepository.save(outboundLeg);

//saveall carried


                quotes.setOutboundLeg(outboundLeg);
               // quoteRepository.save(quotes);








            }

        }


    }
}
