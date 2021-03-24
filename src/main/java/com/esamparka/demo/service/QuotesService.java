package com.esamparka.demo.service;

import com.esamparka.demo.entity.Quotes;
import com.esamparka.demo.entity.QuotesList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class QuotesService {


    @Autowired
    QuoteGetResponseBodyService quoteGetResponseBodyService;
    public List<Quotes> QuotesService() {
        List<Map> list = null;
        List<Quotes> listObjects = new ArrayList<>();
        ResponseEntity<Map> response = quoteGetResponseBodyService.getResponseBody();
        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Quotes");
            for (Map item : list) {
                ModelMapper modelMapper = new ModelMapper();
                Quotes carriers = modelMapper.map(item, Quotes.class);
                Quotes myObject = carriers;
                listObjects.add(myObject);
            }
        }
        return listObjects;


    }
}
