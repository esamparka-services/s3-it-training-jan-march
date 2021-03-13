package com.example.demo.api;

import com.example.demo.model.CommonModel;
import com.example.demo.model.OddEvenModel;
import com.example.demo.model.Palindrome;
import com.example.demo.service.OddEvenService;
import com.example.demo.service.PalindromeService;
import com.example.demo.util.MyStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*

RestFul Api - you expose your program through some API - and then interact with it with REST Operations
The request and response will be json
 */
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.StringCharacterIterator;

@RestController
public class Api {

    //casting
    // String to int
    @Autowired
    OddEvenService oddEvenService;

    @Autowired
    PalindromeService palindromeService;

    @PostMapping("/findOddEven")
    public ResponseEntity oddEvenModel(@RequestBody OddEvenModel oddEvenModel) {
        return new ResponseEntity(oddEvenService.findOutOddOrEven(oddEvenModel), HttpStatus.CREATED);
    }

    @PostMapping("/checkPalindrome")
    public Palindrome checkPalindrome(@RequestBody Palindrome palindrome) {
        palindrome.setPalindrome(MyStringUtil.isPalindrome(palindrome.getString()));
        return palindrome;
    }

    @PostMapping("/checkPalindrome1")
    public Palindrome checkPalindromeRequestParam(@RequestParam String string) {
        Palindrome palindrome = new Palindrome();
        palindrome.setPalindrome(MyStringUtil.isPalindrome(string));
        return palindrome;
    }

//please provide a valid input
//
//    @PostMapping("/isPalindromeAndOddEven")
//    public CommonModel getCommon(@RequestBody CommonModel commonModel) {
//        String failedMessage = "please provide a valid input";
//        String input = commonModel.getString();
//        OddEvenModel oddEvenModel = new OddEvenModel();
//        try {
//            oddEvenModel.setNumber(Integer.parseInt(input));
//            oddEvenModel = oddEvenService.findOutOddOrEven(oddEvenModel);
//            commonModel.setOddOrEven(oddEvenModel.getType());
//
//
//        } catch (Exception e) {
//            System.out.println("Please provide valid inputs " + e.getLocalizedMessage());
//            commonModel.setOddOrEven(failedMessage);
//        }
//
//        //This is for Palindrome
//        boolean isPalindrome = palindromeService.checkPalindrome(input);
//        commonModel.setPalindrome(isPalindrome);
//        return commonModel;
//    }


    @Bean
    public void testBean() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/UK/GBP/en-GB/?query=Stockholm"))
                .header("x-rapidapi-key", "238bf338d4mshe304ac92aba0296p15389djsn1021ce25e2de")
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
