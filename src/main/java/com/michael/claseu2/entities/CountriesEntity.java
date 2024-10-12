package com.michael.claseu2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CountriesEntity {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String code;
    private String description;
}
