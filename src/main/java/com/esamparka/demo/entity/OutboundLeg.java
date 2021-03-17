package com.esamparka.demo.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class OutboundLeg {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int OutboundLegID;
    @OneToMany(cascade = CascadeType.MERGE)
    private Set<CarrierID> carrierID;
    private int OriginId;
    private int DestinationId;
    private LocalDate DepartureDate;

}
