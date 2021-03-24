package com.esamparka.demo.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Quotes {
    @Id
    private int QuoteId;
    private double MinPrice;
    private boolean Direct;
   // @OneToOne(cascade = CascadeType.MERGE)
    private String outboundLeg;
    private Date QuoteDateTime;
}
