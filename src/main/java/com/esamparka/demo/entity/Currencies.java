package com.esamparka.demo.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Currencies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String Code;
    private String Symbol;
    private String ThousandsSeparator;
    private String DecimalSeparator;
    private boolean SymbolOnLeft;
    private boolean SpaceBetweenAmountAndSymbol;
    private int RoundingCoefficient;
    private int DecimalDigits;



}

