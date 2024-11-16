package com.michael.market.services;

import com.michael.market.entities.VegetableEntity;
import com.michael.market.respositories.VegetableRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VegetableService {

    private VegetableRepo vegetableRepo;

    public VegetableService() {

    }

    public List<VegetableEntity> getVegetables() {
        return vegetableRepo.findAll();
    }

    public Optional<VegetableEntity> getVegetables(String id) {
        return vegetableRepo.findById(UUID.fromString(id));
    }

    public VegetableEntity setVegetables(VegetableEntity Vegetables) {
        Vegetables.setId(UUID.randomUUID().toString());
        vegetableRepo.save(Vegetables);
        return Vegetables;
    }

    public VegetableEntity updateVegetables(String id, VegetableEntity Vegetables) {
        this.deleteVegetables(id);
        Vegetables.setId(id);
        vegetableRepo.save(Vegetables);
        return this.setVegetables(Vegetables);
    }

    public Boolean deleteVegetables(String id) {
        try {
            vegetableRepo.deleteById(UUID.fromString(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
