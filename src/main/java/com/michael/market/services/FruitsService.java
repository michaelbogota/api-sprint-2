package com.michael.market.services;

import com.github.javafaker.Faker;
import com.michael.market.entities.FruitsEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FruitsService {
    private List<FruitsEntity> Fruits = new ArrayList<>();
    public FruitsService() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            this.Fruits.add(new FruitsEntity(
                    UUID.randomUUID().toString(),
                    faker.name().name(),
                    faker.code().asin(),
                    faker.code().ean13(),
                    faker.number().randomDigit(),
                    faker.commerce().price()
            ));
        }
    }

    public List<FruitsEntity> getFruits() {
        return Fruits;
    }

    public Optional<FruitsEntity> getFruits(String id) {
        return Fruits.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public FruitsEntity setFruits(FruitsEntity Fruits) {
        Fruits.setId(UUID.randomUUID().toString());
        this.Fruits.add(Fruits);
        return Fruits;
    }

    public FruitsEntity updateFruits(String id, FruitsEntity Fruits) {
        this.deleteFruits(id);
        Fruits.setId(id);
        return this.setFruits(Fruits);
    }

    public Boolean deleteFruits(String id) {
        return Fruits.removeIf(item -> item.getId().equals(id));
    }
}
