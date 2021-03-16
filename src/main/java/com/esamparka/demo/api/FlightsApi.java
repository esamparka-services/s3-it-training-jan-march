package com.esamparka.demo.api;

import com.esamparka.demo.entity.Carriers;
import com.esamparka.demo.entity.Markets;
import com.esamparka.demo.repository.*;
import com.esamparka.demo.service.MarketListService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class FlightsApi {
    @Autowired
    FlightsRepository flightsRepository;

    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    OutboundLegRepository outboundLegRepository;

    @Autowired
    QuoteRepository quoteRepository;

    @Autowired
    MarketListService marketListService;



    @PostMapping("/ListallPlace")
    public void populateDataBasewithPlaces() throws Exception
    {
        String jsonString = marketListService.MarketList();


        JSONObject obj = new JSONObject(jsonString);


        JSONArray arr = obj.getJSONArray("Countries"); // notice that `"posts": [...]`
        for (int i = 0; i < arr.length(); i++)
        {
            Markets markets = new Markets();
            String Code = arr.getJSONObject(i).getString("Code");
            String Name = arr.getJSONObject(i).getString("Name");
            markets.setCode(Code);
            markets.setName(Name);
            flightsRepository.save(markets);


        }


    }
//    {
//        "Quotes": [
//        {
//            "QuoteId": 1,
//                "MinPrice": 98,
//                "Direct": true,
//                "OutboundLeg": {
//            "CarrierIds": [
//            851
//                ],
//            "OriginId": 81727,
//                    "DestinationId": 60987,
//                    "DepartureDate": "2021-04-16T00:00:00"
//        },
//            "QuoteDateTime": "2021-03-14T21:22:00"
//        }
//    ],
//        "Carriers": [
//        {
//            "CarrierId": 851,
//                "Name": "Alaska Airlines"
//        }
//    ],
//        "Places": [
//        {
//            "Name": "New York John F. Kennedy",
//                "Type": "Station",
//                "PlaceId": 60987,
//                "IataCode": "JFK",
//                "SkyscannerCode": "JFK",
//                "CityName": "New York",
//                "CityId": "NYCA",
//                "CountryName": "United States"
//        },
//        {
//            "Name": "San Francisco International",
//                "Type": "Station",
//                "PlaceId": 81727,
//                "IataCode": "SFO",
//                "SkyscannerCode": "SFO",
//                "CityName": "San Francisco",
//                "CityId": "SFOA",
//                "CountryName": "United States"
//        }
//    ],
//        "Currencies": [
//        {
//            "Code": "USD",
//                "Symbol": "$",
//                "ThousandsSeparator": ",",
//                "DecimalSeparator": ".",
//                "SymbolOnLeft": true,
//                "SpaceBetweenAmountAndSymbol": false,
//                "RoundingCoefficient": 0,
//                "DecimalDigits": 2
//        }
//    ]
//    }


















    }
