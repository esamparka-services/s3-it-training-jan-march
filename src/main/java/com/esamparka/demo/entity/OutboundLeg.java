package com.esamparka.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "outboundLeg")
@Data
@Setter
@Getter
public class OutboundLeg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outboundleg_id")
    private int OutboundLegId;
    private int OriginIds;
    private int DestinationIds;
    private Date DepartureDate;



    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "outboundLeg",targetEntity = CarrierId.class)
    private List<CarrierId> carrierId = new ArrayList<CarrierId>();
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "quote_id")
//    private Quotes quotes;





}
