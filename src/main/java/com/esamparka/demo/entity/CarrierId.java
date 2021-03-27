package com.esamparka.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
public class CarrierId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrier_outboundLeg_id")
    private int OutboundlegId;

    private int CarrierId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "outboundleg_id")
    private OutboundLeg outboundLeg;

}
