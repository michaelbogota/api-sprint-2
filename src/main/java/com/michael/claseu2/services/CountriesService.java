package com.michael.claseu2.services;

import com.github.javafaker.Faker;
import com.michael.claseu2.entities.CountriesEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountriesService {
    private List<CountriesEntity> countries = new ArrayList<>();
    public CountriesService() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            this.countries.add(new CountriesEntity(
                    faker.idNumber().toString(),
                    faker.pokemon().name(),
                    faker.university().prefix(),
                    faker.university().suffix()
            ));
        }
    }

    public List<CountriesEntity> getCountries() {
        return countries;
    }

    public Optional<CountriesEntity> getCountries(String id) {
        return countries.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
