package com.esamparka.demo.entity;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Places
{
    @Id
    private int PlaceId;
    private String Name;
    private String Type;
    private String IataCode;
    private String SkyscaanerCode;
    private String CityName;
    private String CityID;
    private String CountryName;

}

