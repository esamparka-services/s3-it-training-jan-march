package com.esamparka.demo.api;

import com.esamparka.demo.entity.Carriers;
import com.esamparka.demo.entity.Quotes;
import com.esamparka.demo.repository.CarrierRepository;
import com.esamparka.demo.repository.QuoteRepository;
import com.esamparka.demo.service.CarrierService;
import com.esamparka.demo.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteApi {

    @Autowired
    QuotesService quotesService;
    @Autowired
    QuoteRepository quoteRepository;
    @PostMapping("/populateQuoteTable")
    public void populateCarrierTable() throws Exception{

        Iterable<Quotes> C = quotesService.QuotesService();
        quoteRepository.saveAll(C);
    }


}
