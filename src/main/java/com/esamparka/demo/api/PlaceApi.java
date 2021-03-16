package com.esamparka.demo.api;


import com.esamparka.demo.entity.Places;
import com.esamparka.demo.repository.PlacesRepository;
import com.esamparka.demo.service.QuoteService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceApi {
    @Autowired
    PlacesRepository placesRepository;

    @Autowired
    QuoteService quoteService;

    @PostMapping("/populatePlaceTable")
    public void populatePlaceTable() throws Exception{
        String jsonString = quoteService.TQuoteService();


        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("Places");
        for (int i = 0; i < arr.length(); i++) {
            Places places = new Places();

           places.setPlaceId(arr.getJSONObject(i).getInt("PlaceId"));
           places.setName( arr.getJSONObject(i).getString("Name"));
            places.setType(arr.getJSONObject(i).getString("Type"));
            places.setIataCode(arr.getJSONObject(i).getString("IataCode"));
            places.setSkyscaanerCode( arr.getJSONObject(i).getString("SkyscannerCode"));
            places.setCityName(arr.getJSONObject(i).getString("CityName"));
            places.setCityID( arr.getJSONObject(i).getString("CityId"));
           places.setCountryName( arr.getJSONObject(i).getString("CountryName"));






            //System.out.println(carriers.getCarrierId() + " " + carriers.getName());
            placesRepository.save(places);
        }
    }
}
