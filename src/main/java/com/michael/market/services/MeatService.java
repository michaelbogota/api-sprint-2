package com.michael.market.services;

import com.github.javafaker.Faker;
import com.michael.market.entities.MeatEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MeatService {
    private List<MeatEntity> Meat = new ArrayList<>();
    public MeatService() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            this.Meat.add(new MeatEntity(
                    UUID.randomUUID().toString(),
                    faker.name().name(),
                    faker.code().asin(),
                    faker.code().ean13(),
                    faker.number().randomDigit(),
                    faker.commerce().price()
            ));
        }
    }

    public List<MeatEntity> getMeat() {
        return Meat;
    }

    public Optional<MeatEntity> getMeat(String id) {
        return Meat.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public MeatEntity setMeat(MeatEntity Meat) {
        Meat.setId(UUID.randomUUID().toString());
        this.Meat.add(Meat);
        return Meat;
    }

    public MeatEntity updateMeat(String id, MeatEntity Meat) {
        this.deleteMeat(id);
        Meat.setId(id);
        return this.setMeat(Meat);
    }

    public Boolean deleteMeat(String id) {
        return Meat.removeIf(item -> item.getId().equals(id));
    }
}
