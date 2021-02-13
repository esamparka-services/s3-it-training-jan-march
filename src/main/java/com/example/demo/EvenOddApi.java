package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EvenOddApi {
    @PostMapping("/getEvenOddResult")
    public EvenOdd getEvenOdd(@RequestBody EvenOdd evenOdd) {

        if (evenOdd.getNumber() % 2 == 0) {
            evenOdd.setResult("This is Even");
        } else {

            evenOdd.setResult("This is Odd");

        }
        return evenOdd;
    }



}
