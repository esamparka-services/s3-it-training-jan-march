package com.assesment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenOrOddRunner {

        @PostMapping("/findEvenOrOdd")
        public EvenOrOdd FindEvenOrOdd(@RequestBody EvenOrOdd evenOrOdd){

            if ((evenOrOdd.getNumber() % 2) == 0) {
                evenOrOdd.setAnswer(" is even number.");
            }
            else {
                evenOrOdd.setAnswer(" is odd number.");
            }
            return evenOrOdd;

    }

}
