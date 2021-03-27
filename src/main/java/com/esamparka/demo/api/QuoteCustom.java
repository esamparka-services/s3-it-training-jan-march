package com.esamparka.demo.api;


import com.esamparka.demo.service.OutboundLegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteCustom {

    @Autowired
    OutboundLegService outboundLegService;


    @PostMapping("/populateQuoteCustomTable")
    public void populatePlaceTable() throws Exception {
   outboundLegService.QuotesService();
    }

}
