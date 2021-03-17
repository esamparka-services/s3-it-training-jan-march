package com.esamparka.demo.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Data
public class Quotes {
    @Id
    private int QuoteId;
    private double MinPrice;
    private boolean Direct;
    @OneToOne(cascade = CascadeType.MERGE)
    private OutboundLeg outboundLeg;
    private LocalDate QuoteDateTime;
}
