package com.esamparka.demo;

import com.esamparka.demo.entity.CarrierId;
import com.esamparka.demo.entity.OutboundLeg;
import com.esamparka.demo.entity.Quotes;
import com.esamparka.demo.repository.CarrierIDRepository;
import com.esamparka.demo.repository.OutBoundRepository;
import com.esamparka.demo.service.QuoteGetResponseBodyService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestOutboundService {


    @Autowired
    QuoteGetResponseBodyService quoteGetResponseBodyService;

    @Autowired
    CarrierIDRepository carrierIDRepository;
    @Autowired
    OutBoundRepository outBoundRepository;

    @Test
    public List<OutboundLeg> QuotesService() {
        List<Map> list = null;
        List<Quotes> listObjects = new ArrayList<>();
        List<OutboundLeg> myObject =null;
        List<CarrierId> carrierIds = null;

        List<Map> outBoundlist = null;
        List<OutboundLeg> outboundLegListObject = new ArrayList<>();

        ResponseEntity<Map> response = quoteGetResponseBodyService.getResponseBody();
        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Quotes");

//            for (Map item : list) {
//
//                outBoundlist = (List<Map>) response.getBody().get("OutboundLeg");
//                for (Map item2 : outBoundlist) {
//                    System.out.println(item2.toString());
//                }
//                }

            for (Map item : list) {


                ModelMapper modelMapper = new ModelMapper();
                Quotes carriers = modelMapper.map(item, Quotes.class);
                LinkedHashMap outboundLegMap = (LinkedHashMap) item.get("OutboundLeg");
                Map convertedMap = outboundLegMap;
                String  s = convertedMap.toString();
                List<Integer> CarriedIDMap  = (List<Integer>) convertedMap.get("CarrierIds");
                for(Integer m: CarriedIDMap) {
                    CarrierId carrierId = new CarrierId();
                    carrierId.setCarrierId(m);

                    carrierIds.add(carrierId);
                }

                //  Iterable<CarrierId> i = carrierIds;

                //carrierIDRepository.saveAll(i);
                // System.out.println(s1);
                // System.out.println("======");
                //carriers.setOutboundLegJSON(s);
                OutboundLeg outboundLeg = modelMapper.map(convertedMap, OutboundLeg.class);
                outboundLeg.setCarrierId(carrierIds);
                // System.out.println(outboundLeg.getDepartureDate());
                myObject.add(outboundLeg);




            }

        }

        return myObject;

    }
}
