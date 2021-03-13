package com.example.demo;

import com.example.demo.model.Palindrome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void myFirstUnitTest() {
        Palindrome palindrome = new Palindrome();
        palindrome.setString("sandeep");
        StringBuffer reversedStringBuffer = new StringBuffer();
        for (int x = palindrome.getString().length() - 1; x >= 0; x--) {
            char reversedChar = (palindrome.getString().charAt(x));
            reversedStringBuffer.append(reversedChar);
        }
        System.out.println(reversedStringBuffer);

    }

    @Test
    public void testVar() {
        int actual = 0;
        try {
            actual = test1(11);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(20, actual);
    }

    private int test1(int x) throws Exception {
        if (x == 10) {
            throw new Exception();
        }
        return 10 + 10;
    }

    @Test
    public void testApi() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US"))
                .header("x-rapidapi-key", "238bf338d4mshe304ac92aba0296p15389djsn1021ce25e2de")
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
