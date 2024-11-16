package com.michael.market.services;

import com.michael.market.entities.FruitsEntity;
import com.michael.market.respositories.FruitsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FruitsService {

    private FruitsRepo fruitsRepo;

    public FruitsService() {

    }

    public List<FruitsEntity> getFruits() {
        return fruitsRepo.findAll();
    }

    public Optional<FruitsEntity> getFruits(String id) {
        return fruitsRepo.findById(UUID.fromString(id));
    }

    public FruitsEntity setFruits(FruitsEntity Fruits) {
        Fruits.setId(UUID.randomUUID().toString());
        fruitsRepo.save(Fruits);
        return Fruits;
    }

    public FruitsEntity updateFruits(String id, FruitsEntity Fruits) {
        this.deleteFruits(id);
        Fruits.setId(id);
        fruitsRepo.save(Fruits);
        return this.setFruits(Fruits);
    }

    public Boolean deleteFruits(String id) {
        try {
            fruitsRepo.deleteById(UUID.fromString(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
