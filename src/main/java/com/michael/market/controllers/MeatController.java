package com.michael.market.controllers;

import com.michael.market.entities.MeatEntity;
import com.michael.market.services.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MeatController {
    @Autowired
    MeatService MeatService;

    @GetMapping("/meat")
    public List<MeatEntity> getMeat() {
        return MeatService.getMeat();
    }

    @GetMapping("/meat/{id}")
    public Optional<MeatEntity> getByIdMeat(@PathVariable String id) {
        return MeatService.getMeat(id);
    }

    @PostMapping("/meat")
    public MeatEntity createMeat(@RequestBody MeatEntity Meat) {
        return MeatService.setMeat(Meat);
    }

    @PutMapping("/meat/{id}")
    public MeatEntity updateMeat(@PathVariable String id, @RequestBody MeatEntity Meat) {
        return MeatService.updateMeat(id, Meat);
    }

    @DeleteMapping("/meat/{id}")
    public Boolean deleteMeat(@PathVariable String id) {
        return MeatService.deleteMeat(id);
    }
}
