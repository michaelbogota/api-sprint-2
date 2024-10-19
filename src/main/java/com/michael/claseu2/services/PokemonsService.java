package com.michael.claseu2.services;

import com.github.javafaker.Faker;
import com.michael.claseu2.entities.PokemonsEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PokemonsService {
    private List<PokemonsEntity> pokemons = new ArrayList<>();
    public PokemonsService() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            this.pokemons.add(new PokemonsEntity(
                    UUID.randomUUID().toString(),
                    faker.pokemon().name(),
                    faker.cat().breed(),
                    faker.number().randomDigitNotZero()
            ));
        }
    }

    public List<PokemonsEntity> getPokemons() {
        return pokemons;
    }

    public Optional<PokemonsEntity> getPokemons(String id) {
        return pokemons.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public Boolean setPokemons(PokemonsEntity pokemons) {
        return this.pokemons.add(pokemons);
    }

    public Boolean updatePokemons(String id, PokemonsEntity pokemons) {
        this.deletePokemons(id);
        pokemons.setId(id);
        return this.setPokemons(pokemons);
    }

    public Boolean deletePokemons(String id) {
        return pokemons.removeIf(item -> item.getId().equals(id));
    }

}
