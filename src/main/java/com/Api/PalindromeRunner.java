package com.Api;

import com.module.PalindromeModule;
import com.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeRunner {

    @Autowired
    PalindromeService palindromeService;

    @PostMapping("/checkPalindrome")
    public PalindromeModule palindrome(@RequestBody PalindromeModule palindromeModule){
        return palindromeService.checkForPalindrome(palindromeModule);
    }

}
