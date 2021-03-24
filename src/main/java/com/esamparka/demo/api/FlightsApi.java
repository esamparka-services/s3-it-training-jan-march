package com.esamparka.demo.api;

import com.esamparka.demo.entity.Markets;
import com.esamparka.demo.repository.*;
import com.esamparka.demo.service.MarketListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FlightsApi {
    @Autowired
    FlightsRepository flightsRepository;

    @Autowired
    MarketListService marketListService;



    @PostMapping("/ListallPlace")
    public void RestImplementation() throws Exception {

        List<Markets> list = marketListService.MarketList();
        Iterable<Markets> marketsList = list;
        flightsRepository.saveAll(marketsList);

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



















