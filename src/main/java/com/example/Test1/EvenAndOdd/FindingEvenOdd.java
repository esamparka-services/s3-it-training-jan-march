package com.example.Test1.EvenAndOdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FindingEvenOdd {
    @GetMapping("/findEvenOdd")
    public String Test() {
        int number = 2;

        if (number % 2 == 0) {
            return "It is even.";
        } else {
            return "It is odd";

        }

    }


}
