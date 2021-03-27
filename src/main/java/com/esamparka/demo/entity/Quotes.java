package com.esamparka.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Quotes {
    @Id
    @Column(name = "quote_id")
    private int QuoteId;
    private double MinPrice;
    private boolean Direct;
    private Date QuoteDateTime;
    private String outboundLegJSON;

    @OneToOne(cascade = CascadeType.ALL)
    private OutboundLeg outboundLeg;
    @Transient
    private int OutboundId;

//    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "quotes",targetEntity = OutboundLeg.class)
//    private List<OutboundLeg> outboundLeg;

}
