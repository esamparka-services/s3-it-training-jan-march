package com.example.demo.assessment;

import com.example.demo.model.Palindrome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeApi {

    @Autowired
    PalindromeServiceProvider palindromeServiceProvider;

    @PostMapping("/palindrome")
    public String  palindromeResult(){
        return palindromeResult();
    }
}


