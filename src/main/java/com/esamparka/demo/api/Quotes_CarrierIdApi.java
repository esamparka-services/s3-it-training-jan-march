package com.esamparka.demo.api;

import com.esamparka.demo.entity.CarrierID;
import com.esamparka.demo.repository.Quotes_CarrierId_Repository;
import com.esamparka.demo.service.QuoteService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Quotes_CarrierIdApi {

    @Autowired
    Quotes_CarrierId_Repository quotes_carrierId_repository;

    @Autowired
    QuoteService quoteService;

    @PostMapping("/populateQuoteCarrierIDTable")
    public void populateQuoteCarrierIDTable() throws Exception {
        String jsonString = quoteService.TQuoteService();
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("Quotes");

        for (int i = 0; i < arr.length(); i++) {
            CarrierID carrierID = new CarrierID();
            JSONObject obj2 = new JSONObject(arr.getJSONObject(i).getString("OutboundLeg"));

            JSONArray arr2 = obj2.getJSONArray("CarrierIds");
            int[] numbers = new int[arr2.length()];


            for (int m = 0; m < arr2.length(); m++) {
                numbers[m] = arr2.optInt(m);
                carrierID.setCarrier_id(numbers[m]);
                quotes_carrierId_repository.save(carrierID);
            }


        }

    }


}



