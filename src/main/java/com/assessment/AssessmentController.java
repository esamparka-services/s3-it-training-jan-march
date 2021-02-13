package com.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssessmentController {

    @Autowired
    AssessmentService assessmentService;

    @PostMapping("/ifEvenOrOddNumber")
    public String ifEvenOrOdd(@RequestBody Assessment a){
        return assessmentService.ifOddOrEven(a.getNumber());
    }

}
