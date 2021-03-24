package com.esamparka.demo.entity;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
public class OutboundLeg {

    @Id
    private int CarrierIds;
    private int OriginIds;
    private int DestinationIds;
    private Date DepartureDate;

    @ManyToOne
    Quotes quotes;
}
