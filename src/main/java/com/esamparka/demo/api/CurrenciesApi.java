package com.esamparka.demo.api;

import com.esamparka.demo.entity.Currencies;
import com.esamparka.demo.repository.CurrencyRepository;
import com.esamparka.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrenciesApi {
    @Autowired
CurrencyRepository currencyRepository;

    @Autowired
    CurrencyService currencyService;

            @PostMapping("/PopulateCurrenciesTable")
    public  void populateCurrency()
            {
                Iterable<Currencies> C = currencyService.CurrencyService();
                currencyRepository.saveAll(C);
            }
}
