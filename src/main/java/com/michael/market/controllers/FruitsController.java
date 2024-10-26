package com.michael.market.controllers;

import com.michael.market.entities.FruitsEntity;
import com.michael.market.services.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FruitsController {

    @Autowired
    FruitsService FruitsService;

    @GetMapping("/fruits")
    public List<FruitsEntity> getFruits() {
        return FruitsService.getFruits();
    }

    @GetMapping("/fruits/{id}")
    public Optional<FruitsEntity> getByIdFruits(@PathVariable String id) {
        return FruitsService.getFruits(id);
    }

    @PostMapping("/fruits")
    public FruitsEntity createFruits(@RequestBody FruitsEntity Fruits) {
        return FruitsService.setFruits(Fruits);
    }

    @PutMapping("/fruits/{id}")
    public FruitsEntity updateFruits(@PathVariable String id, @RequestBody FruitsEntity Fruits) {
        return FruitsService.updateFruits(id, Fruits);
    }

    @DeleteMapping("/fruits/{id}")
    public Boolean deleteFruits(@PathVariable String id) {
        return FruitsService.deleteFruits(id);
    }
}
