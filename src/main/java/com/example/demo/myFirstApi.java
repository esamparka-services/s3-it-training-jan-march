package com.example.demo;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class myFirstApi {

    public String Hello()
    {
        return "Hi ! where are you?";
    }


}