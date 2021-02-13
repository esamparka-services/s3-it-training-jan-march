package com.example.demo.assessment;

import com.example.demo.model.OddEven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OddEvenApi {

@Autowired
OddEvenServiceProvider oddEvenServiceProvider;

    @GetMapping("/findOddEven")
    public String getOddEven() {
        return oddEvenServiceProvider.getOddEvenResult();
    }


}
