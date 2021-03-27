package com.example.demo.model.flights;

import lombok.Data;

import java.util.List;

@Data
public class QuoteList {
    private List<Quotes> Quotes;
    private List<Places> Places;
}
