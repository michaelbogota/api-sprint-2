package com.michael.market.controllers;

import com.michael.market.entities.BakeryEntity;
import com.michael.market.services.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BakeryController {
    @Autowired
    BakeryService BakeryService;

    @GetMapping("/bakery")
    public List<BakeryEntity> getBakery() {
        return BakeryService.getBakery();
    }

    @GetMapping("/bakery/{id}")
    public Optional<BakeryEntity> getByIdBakery(@PathVariable String id) {
        return BakeryService.getBakery(id);
    }

    @PostMapping("/bakery")
    public BakeryEntity CreateBakery(@RequestBody BakeryEntity Bakery) {
        return BakeryService.setBakery(Bakery);
    }

    @PutMapping("/bakery/{id}")
    public BakeryEntity updateBakery(@PathVariable String id, @RequestBody BakeryEntity Bakery) {
        return BakeryService.updateBakery(id, Bakery);
    }

    @DeleteMapping("/bakery/{id}")
    public Boolean deleteBakery(@PathVariable String id) {
        return BakeryService.deleteBakery(id);
    }
}
