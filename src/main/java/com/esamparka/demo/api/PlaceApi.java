package com.esamparka.demo.api;


import com.esamparka.demo.entity.Places;
import com.esamparka.demo.repository.PlacesRepository;
import com.esamparka.demo.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceApi {
    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    PlacesService placesService;

    @PostMapping("/populatePlaceTable")
    public void populatePlaceTable() throws Exception{

        Iterable<Places> C = placesService.PlaceServices();
        placesRepository.saveAll(C);
        }
    }

