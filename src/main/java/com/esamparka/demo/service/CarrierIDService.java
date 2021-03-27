package com.esamparka.demo.service;

import com.esamparka.demo.entity.OutboundLeg;
import com.esamparka.demo.entity.Quotes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service

public class CarrierIDService {

    @Autowired
    private QuoteGetResponseBodyService quoteGetResponseBodyService;

    public List<Integer> CarrierIDService() {
        List<Map> list = null;
       // List<Quotes> carriedIDList = new ArrayList<>();

        List<Integer> carriedIDList = null;
        ResponseEntity<Map> response = quoteGetResponseBodyService.getResponseBody();
        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Quotes");

//            for (Map item : list) {
//
//                outBoundlist = (List<Map>) response.getBody().get("OutboundLeg");
//                for (Map item2 : outBoundlist) {
//                    System.out.println(item2.toString());
//                }
//            }

            for (Map item : list) {


                ModelMapper modelMapper = new ModelMapper();
                Quotes carriers = modelMapper.map(item, Quotes.class);
                LinkedHashMap outboundLegMap = (LinkedHashMap) item.get("OutboundLeg");
                Map convertedMap = outboundLegMap;
                String  s = convertedMap.toString();
                carriedIDList  = (List<Integer>) convertedMap.get("CarrierIds");
                //System.out.println(CarriedIDMap.toString());
               // Iterable<Integer> i = CarriedIDMap;

                //carrierIDRepository.saveAll(i);
                // System.out.println(s1);
                // System.out.println("======");
                //carriers.setOutboundLegJSON(s);
                //OutboundLeg outboundLeg = modelMapper.map(convertedMap, OutboundLeg.class);
                // System.out.println(outboundLeg.getDepartureDate());





            }

        }

        return carriedIDList;

    }
}
