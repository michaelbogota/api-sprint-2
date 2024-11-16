package com.michael.market.services;

import com.michael.market.entities.BakeryEntity;
import com.michael.market.respositories.BakeryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BakeryService {

    private BakeryRepo bakeryRepo;

    public BakeryService() {

    }

    public List<BakeryEntity> getBakery() {
        return bakeryRepo.findAll();
    }

    public Optional<BakeryEntity> getBakery(String id) {
        return bakeryRepo.findById(UUID.fromString(id));
    }

    public BakeryEntity setBakery(BakeryEntity Bakery) {
        Bakery.setId(UUID.randomUUID().toString());
        bakeryRepo.save(Bakery);
        return Bakery;
    }

    public BakeryEntity updateBakery(String id, BakeryEntity Bakery) {
        this.deleteBakery(id);
        Bakery.setId(id);
        bakeryRepo.save(Bakery);
        return this.setBakery(Bakery);
    }

    public Boolean deleteBakery(String id) {
        try {
            bakeryRepo.deleteById(UUID.fromString(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
