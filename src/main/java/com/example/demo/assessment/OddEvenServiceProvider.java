package com.example.demo.assessment;

import com.example.demo.model.OddEven;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OddEvenServiceProvider {
    public OddEven getOddEvenResult(@RequestBody OddEven oddEven){
        if (oddEven.getNumber() % 2 == 0){
            oddEven.setType("even");
        }
        else {
            oddEven.setType("odd");
        }
        return oddEven;
    }

}
