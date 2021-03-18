package com.example.demo.palindrome;

import com.example.demo.palindrome.Driver;
import com.example.demo.palindrome.PalindromeCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeCheckApi {

    @Autowired
    Driver driver;

    @PostMapping("/isPalindrome")

        public PalindromeCheck checkResult (@RequestBody PalindromeCheck palindromeCheck){

        return driver.findPalindrome(palindromeCheck);
    }

}