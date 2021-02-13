package com.example.demo.api;

import com.example.demo.Laptop;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopApi {
    @PostMapping("/getLaptopDetails")
    public Laptop getLaptopDetails(@RequestBody Laptop laptop) {
        if (laptop.getName().equals("macbook") && laptop.getModel().equals("pro")) {
            laptop.setPrice("$200");
        }
        return laptop;
    }
}

