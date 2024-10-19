package com.michael.claseu2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PokemonsEntity {
    private String id;
    private String name;
    private String code;
    private Integer level;
}
