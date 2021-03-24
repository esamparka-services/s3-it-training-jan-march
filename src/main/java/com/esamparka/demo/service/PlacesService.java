package com.esamparka.demo.service;

import com.esamparka.demo.entity.Places;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlacesService {

    @Autowired
    QuoteGetResponseBodyService quoteGetResponseBodyService;
    public List<Places> PlaceServices() {
        List<Map> list = null;
        List<Places> listObjects = new ArrayList<>();
        ResponseEntity<Map> response = quoteGetResponseBodyService.getResponseBody();

        if (response != null && response.getStatusCode().value() == 200) {
            list = (List<Map>) response.getBody().get("Places");
            for (Map item : list) {
                ModelMapper modelMapper = new ModelMapper();
                Places places = modelMapper.map(item, Places.class);
                Places myObject = places;
                listObjects.add(myObject);
            }
        }
        return listObjects;


    }
}
