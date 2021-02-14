package com.assessment;

import org.springframework.stereotype.Service;

@Service
public class AssessmentService {

    public String ifOddOrEven(int number) {

        if (number % 2 == 0) {
            return "even";
        }
        else{
            return "odd";
        }


    }
}
//