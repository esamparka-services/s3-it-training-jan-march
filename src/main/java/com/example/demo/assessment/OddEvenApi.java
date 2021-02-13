package com.example.demo.assessment;

import com.example.demo.model.OddEven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OddEvenApi {



    @GetMapping("/findOddEven")
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
