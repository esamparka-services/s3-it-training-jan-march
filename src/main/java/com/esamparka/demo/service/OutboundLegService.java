package com.esamparka.demo.service;

import com.esamparka.demo.entity.CarrierId;
import com.esamparka.demo.entity.OutboundLeg;
import com.esamparka.demo.entity.Quotes;
import com.esamparka.demo.repository.CarrierIDRepository;
import com.esamparka.demo.repository.OutBoundRepository;
import com.esamparka.demo.repository.QuoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OutboundLegService {

    @Autowired
    private QuoteRepository quoteRepository;
    @Autowired
    QuoteGetResponseBodyService quoteGetResponseBodyService;
    @Autowired
    CarrierIDRepository carrierIDRepository;
    @Autowired
    OutBoundRepository outBoundRepository;

    public void QuotesService() {
        List<Map> list ;
        List<CarrierId> carrierIdList = new ArrayList<>();


        ResponseEntity<Map> response = quoteGetResponseBodyService.getResponseBody();
        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Quotes");

            for (Map item : list) {
                ModelMapper modelMapper = new ModelMapper();
                modelMapper.getConfiguration().setAmbiguityIgnored(true);
                //  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

                Quotes quotes = modelMapper.map(item, Quotes.class);

                Map convertedMap = (Map) item.get("OutboundLeg");

                quotes.setOutboundLegJSON(convertedMap.toString());

                OutboundLeg outboundLeg = modelMapper.map(convertedMap, OutboundLeg.class);
                List<Integer> CarriedIDMap = (List<Integer>) convertedMap.get("CarrierIds");
                for (Integer m : CarriedIDMap) {
                    CarrierId carrierId = new CarrierId();
                    carrierId.setCarrierId(m);
                    carrierId.setOutboundLeg(outboundLeg);

                    carrierIdList.add(carrierId);
                }

                outboundLeg.setCarrierId(carrierIdList);
                outBoundRepository.save(outboundLeg);

                Iterable<CarrierId> carrierIds = carrierIdList;
                carrierIDRepository.saveAll(carrierIds);

                quotes.setOutboundLeg(outboundLeg);
                quoteRepository.save(quotes);

            }

        }

    }
}

