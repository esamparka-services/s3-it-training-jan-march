package com.esamparka.demo.service;


import com.esamparka.demo.entity.Currencies;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class CurrencyService {

    @Autowired
    QuoteGetResponseBodyService quoteGetResponseBodyService;

    public List<Currencies> CurrencyService() {

        List<Map> list = null;
        List<Currencies> listObjects = new ArrayList<>();
        ResponseEntity<Map> response = quoteGetResponseBodyService.getResponseBody();

        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Currencies");

            for (Map item : list) {

                ModelMapper modelMapper = new ModelMapper();
                Currencies myObject = modelMapper.map(item, Currencies.class);
                listObjects.add(myObject);
            }

        }
        return listObjects;


    }


}
