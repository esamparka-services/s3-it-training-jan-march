package com.example.demo.api;

import com.example.demo.Service.CurrenciesService;
import com.example.demo.entity.Currencies;
import com.example.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrenciesApi {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    CurrenciesService currenciesService;

    @PostMapping("/displayCurrencies")

    public void displayCurrencies() {
         {
            Iterable<Currencies> currenciesList = currenciesService.CurrencyService();
            flightRepository.saveAll(currenciesList);
        }

    }
}