package com.Assessment1.Assessment1.Api;


import com.Assessment1.Assessment1.Model.EvenOddModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenOddApi {
    @PostMapping("/findEvenOdd")
    public EvenOddModel evenOdd(@RequestBody EvenOddModel evenOddModel) {

        if ((evenOddModel.getNumber() % 2) == 0) {
            evenOddModel.setType("Even");
            //evenOddModel.setNumber(100);
        } else {
            evenOddModel.setType("Odd");

        } return evenOddModel;


    }

}
