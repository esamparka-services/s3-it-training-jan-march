package com.esamparka.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Quotes {
    @Id
    private int QuoteId;
    private double MinPrice;
    private boolean Direct;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OutboundLeg> outboundLeg;
    private Date QuoteDateTime;
}
