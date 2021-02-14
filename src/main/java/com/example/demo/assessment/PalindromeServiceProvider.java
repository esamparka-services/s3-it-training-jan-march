package com.example.demo.assessment;

import com.example.demo.model.OddEven;
import com.example.demo.model.Palindrome;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PalindromeServiceProvider {

    public Palindrome palindromeResult(@RequestBody Palindrome palindrome){
        char[] characters = palindrome.getString().toCharArray();
         String result = "";

        for( int i = characters.length -1 ;i >= 0 ;i--){
             result =  result + characters[i];
        }

        palindrome.setReversedString(result);

        if (palindrome.getString().equals(result)){
            palindrome.setPalindrome(true);
        }
        else {
            palindrome.setPalindrome(false);
        }
        return palindrome;
    }

}

