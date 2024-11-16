package com.michael.market.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FruitsEntity {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String code;
    private String reference;
    private Integer Stock;
    private String Price;
}
