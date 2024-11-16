package com.michael.market.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MeatEntity {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String code;
    private String reference;
    private Integer Stock;
    private String Price;
}
