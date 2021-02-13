package com.checkpaliondrome.demo.service;

import com.checkpaliondrome.demo.module.PaliondromeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaliondromeService {

    public PaliondromeModule findPaliondrome(PaliondromeModule paliondromeModule) {

        String word = paliondromeModule.getString();
        int wordLength = word.length();

        if (word.length() == 0) {
            paliondromeModule.setMessage("Empty String entered");

        } else {
            String reverseWord = "";
            for (int i = 0; i < wordLength; i++) {
                reverseWord = reverseWord.concat(String.valueOf(word.charAt(wordLength - (i + 1))));
            }
            paliondromeModule.setPaliondrome(reverseWord.equalsIgnoreCase(word));
            paliondromeModule.setReversedString(reverseWord);
            paliondromeModule.setMessage("Reverse String generated and Paliondrome checked too.");
        }
        return paliondromeModule;
    }


}
