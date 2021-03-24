package com.esamparka.demo.service;

import com.esamparka.demo.entity.Carriers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CarrierService {


    @Autowired
    QuoteGetResponseBodyService quoteGetResponseBodyService;
    public List<Carriers> CarrierService() {
        List<Map> list = null;
        List<Carriers> listObjects = new ArrayList<>();
        ResponseEntity<Map> response = quoteGetResponseBodyService.getResponseBody();
        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Carriers");
            for (Map item : list) {
                ModelMapper modelMapper = new ModelMapper();
                Carriers carriers = modelMapper.map(item, Carriers.class);
                Carriers myObject = carriers;
                listObjects.add(myObject);
            }
        }
        return listObjects;


    }


}
