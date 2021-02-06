package com.example.demo;

import com.example.demo.api.MyFirstApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
        MyFirstApi myFirstApi = new MyFirstApi();
        System.out.println(myFirstApi.hello());

    }

}
