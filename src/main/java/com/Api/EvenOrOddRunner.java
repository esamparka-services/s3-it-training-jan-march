package com.Api;

import com.module.EvenOrOdd;
import com.service.EvenOrOddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenOrOddRunner {

    @Autowired
    EvenOrOddService evenOrOddService;

        @PostMapping("/findEvenOrOdd")
        public EvenOrOdd FindEvenOrOdd(@RequestBody EvenOrOdd evenOrOdd){

           return evenOrOddService.findOfEvenOrOdd(evenOrOdd);

    }

}
