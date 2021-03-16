package com.esamparka.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class Carriers {
    @Id
    private int CarrierId;
    private String Name;
}
