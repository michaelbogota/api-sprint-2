package com.michael.market.services;

import com.michael.market.entities.MeatEntity;
import com.michael.market.respositories.MeatRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MeatService {

    private MeatRepo meatRepo;

    public MeatService() {

    }

    public List<MeatEntity> getMeat() {
        return meatRepo.findAll();
    }

    public Optional<MeatEntity> getMeat(String id) {
        return meatRepo.findById(UUID.fromString(id));
    }

    public MeatEntity setMeat(MeatEntity Meat) {
        Meat.setId(UUID.randomUUID().toString());
        meatRepo.save(Meat);
        return Meat;
    }

    public MeatEntity updateMeat(String id, MeatEntity Meat) {
        this.deleteMeat(id);
        Meat.setId(id);
        meatRepo.save(Meat);
        return this.setMeat(Meat);
    }

    public Boolean deleteMeat(String id) {
        try {
            meatRepo.deleteById(UUID.fromString(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
