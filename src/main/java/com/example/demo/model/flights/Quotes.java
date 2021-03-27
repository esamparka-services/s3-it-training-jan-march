package com.example.demo.model.flights;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Quotes {
    private int quoteId;
    private int minPRice;
    private boolean direct;
    private List<OutBoundLeg> outBoundLeg;
    private Date quoteDateTime;
}
