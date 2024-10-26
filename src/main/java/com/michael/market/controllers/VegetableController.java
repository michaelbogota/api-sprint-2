package com.michael.market.controllers;

import com.michael.market.services.VegetableService;
import com.michael.market.entities.VegetableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class VegetableController {
    @Autowired
    VegetableService VegetableService;

    @GetMapping("/vegetable")
    public List<VegetableEntity> getVegetables() {
        return VegetableService.getVegetables();
    }

    @GetMapping("/vegetable/{id}")
    public Optional<VegetableEntity> getByIdVegetables(@PathVariable String id) {
        return VegetableService.getVegetables(id);
    }

    @PostMapping("/vegetable")
    public VegetableEntity createVegetables(@RequestBody VegetableEntity Vegetables) {
        return VegetableService.setVegetables(Vegetables);
    }

    @PutMapping("/vegetable/{id}")
    public VegetableEntity updateVegetables(@PathVariable String id, @RequestBody VegetableEntity Vegetables) {
        return VegetableService.updateVegetables(id, Vegetables);
    }

    @DeleteMapping("/vegetable/{id}")
    public Boolean deleteVegetables(@PathVariable String id) {
        return VegetableService.deleteVegetables(id);
    }
}
