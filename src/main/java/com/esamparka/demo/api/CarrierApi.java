package com.esamparka.demo.api;

import com.esamparka.demo.entity.Carriers;
import com.esamparka.demo.repository.CarrierRepository;
import com.esamparka.demo.service.QuoteService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarrierApi {

    @Autowired
    QuoteService quoteService;
    @Autowired
    CarrierRepository carrierRepository;
    @PostMapping("/populateCarrierTable")
    public void populateCarrierTable() throws Exception{
        String jsonString = quoteService.TQuoteService();

        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("Carriers");
        for (int i = 0; i < arr.length(); i++) {
            int carrierId = arr.getJSONObject(i).getInt("CarrierId");
            String Name = arr.getJSONObject(i).getString("Name");

            Carriers carriers = new Carriers();
            carriers.setName(Name);
            carriers.setCarrierId(carrierId);

            //System.out.println(carriers.getCarrierId() + " " + carriers.getName());
            carrierRepository.save(carriers);
        }
    }

}