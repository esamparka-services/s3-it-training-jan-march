package com.service;

import com.module.PalindromeModule;
import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
    public PalindromeModule checkForPalindrome(PalindromeModule palindromeModule){
        String word = palindromeModule.getYourWord();
        int wordLength = word.length();
        String reverseWord="";

        for (int i = 0; i < wordLength; i++) {
            reverseWord = reverseWord.concat(String.valueOf(word.charAt(wordLength - (i + 1))));
        }
        palindromeModule.setPalindrome(reverseWord.equalsIgnoreCase(word)); //for true or false
        palindromeModule.setReverseString(reverseWord);
        return palindromeModule;

    }

}
