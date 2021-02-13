package com.service;

import com.module.EvenOrOdd;
import org.springframework.stereotype.Service;

@Service
public class EvenOrOddService {
    public EvenOrOdd findOfEvenOrOdd(EvenOrOdd evenOrOdd){
        if ((evenOrOdd.getNumber() % 2) == 0) {
            evenOrOdd.setAnswer(" is even number.");
        }
        else {
            evenOrOdd.setAnswer(" is odd number.");
        }
        return evenOrOdd;
    }
}
