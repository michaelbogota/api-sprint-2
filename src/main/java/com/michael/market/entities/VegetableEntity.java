package com.michael.market.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class VegetableEntity {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String code;
    private String reference;
    private Integer Stock;
    private String Price;
}
