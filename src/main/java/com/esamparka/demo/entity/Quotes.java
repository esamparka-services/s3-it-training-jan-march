package com.esamparka.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Quotes {
    @Id
    private int QuoteId;
    private double MinPrice;
    private boolean Direct;
    private int OutboundLegID;
    private LocalDate QuoteDateTime;
}
