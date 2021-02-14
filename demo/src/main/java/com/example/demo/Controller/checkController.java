package com.example.demo.Controller;

import com.example.demo.Modal.Word;
import com.example.demo.Repository.CheckRespository;
import com.example.demo.Repository.ICheckRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class checkController {
    ICheckRepository check = new CheckRespository();

    @PostMapping("/Palindrome")
    public Word checkPalindrome(@RequestBody Word word){
        String s = word.getWord();
        word.setReverseWord(check.findReverse(s));
        word.setCheckPalindromes(check.isPalindrome(s));
        return word;
    }
}
