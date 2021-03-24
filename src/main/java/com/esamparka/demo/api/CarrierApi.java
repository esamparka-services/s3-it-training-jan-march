package com.esamparka.demo.api;

import com.esamparka.demo.entity.Carriers;
import com.esamparka.demo.repository.CarrierRepository;
import com.esamparka.demo.service.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarrierApi {

    @Autowired
    CarrierService carrierService;
    @Autowired
    CarrierRepository carrierRepository;
    @PostMapping("/populateCarrierTable")
    public void populateCarrierTable() throws Exception{

        Iterable<Carriers> carriersList = carrierService.CarrierService();
        carrierRepository.saveAll(carriersList);
    }

}