package com.esamparka.demo.entity;

import jdk.jfr.Enabled;
import lombok.Data;
import lombok.Value;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.GeneratorType;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class OutboundLeg {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int OutboundLegID;
    private int  CarrierIds;
    private int OriginId;
    private int DestinationId;
    private LocalDate DepartureDate;

}
