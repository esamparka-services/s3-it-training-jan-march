package com.esamparka.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CarrierID {
    @Id
    private int carrier_id;


}
