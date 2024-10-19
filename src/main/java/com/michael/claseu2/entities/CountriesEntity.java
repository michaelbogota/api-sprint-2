package com.michael.claseu2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountriesEntity {
    private String id;
    private String name;
    private String code;
    private String description;
}
