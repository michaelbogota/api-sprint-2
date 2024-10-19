package com.michael.claseu2.controllers;

import com.michael.claseu2.entities.CountriesEntity;
import com.michael.claseu2.services.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<CountriesEntity> getByIdCountries(@PathVariable String id) {
        return countriesService.getCountries(id);
    }

    @PostMapping("/countries")
    public Boolean createCountries(@RequestBody CountriesEntity country) {
        return countriesService.setCountries(country);
    }

    @PutMapping("/countries/{id}")
    public Boolean updateCountries(@PathVariable String id, @RequestBody CountriesEntity country) {
        return countriesService.updateCountries(id, country);
    }

    @DeleteMapping("/countries/{id}")
    public Boolean deleteCountries(@PathVariable String id) {
        return countriesService.deleteCountries(id);
    }
}
