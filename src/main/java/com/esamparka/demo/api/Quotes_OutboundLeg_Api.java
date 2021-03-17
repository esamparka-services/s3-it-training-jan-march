package com.esamparka.demo.api;

import com.esamparka.demo.entity.CarrierID;
import com.esamparka.demo.entity.OutboundLeg;
import com.esamparka.demo.repository.OutboundLegRepository;
import com.esamparka.demo.repository.Quotes_CarrierId_Repository;
import com.esamparka.demo.service.QuoteService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
public class Quotes_OutboundLeg_Api {
    @Autowired
    OutboundLegRepository outboundLegRepository;

    @Autowired
    QuoteService quoteService;

    @PostMapping("/QuotesOutBoundLegTable")
    public void populateQuotesOutBoundLegTable() throws Exception {
        String jsonString = quoteService.TQuoteService();
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("Quotes");

        System.out.println("Start");
        for (int i = 0; i < arr.length(); i++) {
            OutboundLeg outboundLeg = new OutboundLeg();
            JSONObject obj2 = new JSONObject(arr.getJSONObject(i).getString("OutboundLeg"));

            JSONArray arr2 = obj2.getJSONArray("CarrierIds");
            int[] numbers = new int[arr2.length()];
            Set<CarrierID> s = new HashSet<>();
            for (int m = 0; m < arr2.length(); m++) {
                numbers[m] = arr2.optInt(m);
                CarrierID carrierID = new CarrierID();
                carrierID.setCarrier_id(numbers[m]);
                s.add(carrierID);
            }
            int destination_id = obj2.getInt("DestinationId");
                    int origin_id = obj2.getInt("OriginId");

            System.out.println("Designation is" + destination_id);
            String created =(String) obj2.get("DepartureDate");
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDate newDate = LocalDate.parse(created,format);


            outboundLeg.setCarrierID(s);
            outboundLeg.setDepartureDate(newDate);
            outboundLeg.setOriginId(origin_id);
            outboundLeg.setDestinationId(destination_id);

outboundLegRepository.save(outboundLeg);



        }

    }
}
