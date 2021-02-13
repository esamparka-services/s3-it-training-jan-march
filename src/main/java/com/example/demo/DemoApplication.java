package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
//		myFirstApi myFirstApi = new myFirstApi();
//		System.out.println(myFirstApi.Hello());

		EvenOddApi evenOddApi = new EvenOddApi();
		//System.out.println(evenOddApi.getEvenOdd());
	}

	}

