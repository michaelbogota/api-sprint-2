package com.michael.market.services;

import com.github.javafaker.Faker;
import com.michael.market.entities.VegetableEntity;
import com.michael.market.entities.VegetableEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class VegetableService {
    private List<VegetableEntity> Vegetables = new ArrayList<>();
    public VegetableService() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            this.Vegetables.add(new VegetableEntity(
                    UUID.randomUUID().toString(),
                    faker.name().name(),
                    faker.code().asin(),
                    faker.code().ean13(),
                    faker.number().randomDigit(),
                    faker.commerce().price()
            ));
        }
    }

    public List<VegetableEntity> getVegetables() {
        return Vegetables;
    }

    public Optional<VegetableEntity> getVegetables(String id) {
        return Vegetables.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public VegetableEntity setVegetables(VegetableEntity Vegetables) {
        Vegetables.setId(UUID.randomUUID().toString());
        this.Vegetables.add(Vegetables);
        return Vegetables;
    }

    public VegetableEntity updateVegetables(String id, VegetableEntity Vegetables) {
        this.deleteVegetables(id);
        Vegetables.setId(id);
        return this.setVegetables(Vegetables);
    }

    public Boolean deleteVegetables(String id) {
        return Vegetables.removeIf(item -> item.getId().equals(id));
    }
}
