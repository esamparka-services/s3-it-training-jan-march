package com.example.demo;

import com.example.demo.palindrome.PalindromeCheckApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
//		myFirstApi myFirstApi = new myFirstApi();
//		System.out.println(myFirstApi.Hello());

		//EvenOddApi evenOddApi = new EvenOddApi();
		//System.out.println(evenOddApi.getEvenOdd());

       //PalindromeCheckApi palindromeCheckApi = new PalindromeCheckApi();
	}
//
//    @RestController
//    public static class LaptopApi {
//        @PostMapping("/getLaptopDetails")
//        public Laptop getLaptopDetails(@RequestBody Laptop laptop) {
//            if (laptop.getName().equals("macbook") && laptop.getModel().equals("pro")) {
//                laptop.setPrice("$200");
//            }
//            return laptop;
//        }




//	@Test
//	public void testApi() throws IOException, InterruptedException {
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/en-US"))
//				.header("x-rapidapi-key", "238bf338d4mshe304ac92aba0296p15389djsn1021ce25e2de")
//				.header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
//				.method("GET", HttpRequest.BodyPublishers.noBody())
//				.build();
//		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());
//	}
    }


