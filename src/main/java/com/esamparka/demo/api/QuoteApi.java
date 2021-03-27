package com.esamparka.demo.api;

import com.esamparka.demo.entity.Quotes;
import com.esamparka.demo.repository.CarrierIDRepository;
import com.esamparka.demo.repository.OutBoundRepository;
import com.esamparka.demo.repository.QuoteRepository;
import com.esamparka.demo.service.CarrierIDService;
import com.esamparka.demo.service.OutboundLegService;
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

    @Autowired
    OutBoundRepository outBoundRepository;
    @Autowired
    OutboundLegService outboundLegService;

    @Autowired
    CarrierIDRepository carrierIDRepository;
    @Autowired
    CarrierIDService carrierIDService;
    @PostMapping("/populateQuoteTable")
    public void populateCarrierTable() throws Exception{

        Iterable<Quotes> quotesList = quotesService.QuotesService();

        System.out.println(quotesList.toString());
        quoteRepository.saveAll(quotesList);




    }


}
