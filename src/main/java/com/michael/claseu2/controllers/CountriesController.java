package com.michael.claseu2.controllers;

import com.michael.claseu2.entities.CountriesEntity;
import com.michael.claseu2.services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CountriesController {

    @Autowired
    CountriesService countriesService;
    @GetMapping("/countries")
    public List<CountriesEntity> getCountries() {
        return countriesService.getCountries();
    }

    @GetMapping("/countries/{id}")
    public String getByIdCountries(@PathVariable String id) {
        return "";
    }

    @PostMapping("/countries")
    public String createCountries(String[] args) {
        return "";
    }

    @PutMapping("/countries/{id}")
    public String updateCountries(@PathVariable String id, @RequestBody Object country) {
        return "";
    }

    @DeleteMapping("/countries/{id}")
    public String deleteCountries(@PathVariable String id) {
        return "";
    }
}
