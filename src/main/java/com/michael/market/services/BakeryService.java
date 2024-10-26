package com.michael.market.services;

import com.github.javafaker.Faker;
import com.michael.market.entities.BakeryEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BakeryService {
    private List<BakeryEntity> Bakery = new ArrayList<>();
    public BakeryService() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            this.Bakery.add(new BakeryEntity(
                    UUID.randomUUID().toString(),
                    faker.name().name(),
                    faker.code().asin(),
                    faker.code().ean13(),
                    faker.number().randomDigit(),
                    faker.commerce().price()
            ));
        }
    }

    public List<BakeryEntity> getBakery() {
        return Bakery;
    }

    public Optional<BakeryEntity> getBakery(String id) {
        return Bakery.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public BakeryEntity setBakery(BakeryEntity Bakery) {
        Bakery.setId(UUID.randomUUID().toString());
        this.Bakery.add(Bakery);
        return Bakery;
    }

    public BakeryEntity updateBakery(String id, BakeryEntity Bakery) {
        this.deleteBakery(id);
        Bakery.setId(id);
        return this.setBakery(Bakery);
    }

    public Boolean deleteBakery(String id) {
        return Bakery.removeIf(item -> item.getId().equals(id));
    }
}
