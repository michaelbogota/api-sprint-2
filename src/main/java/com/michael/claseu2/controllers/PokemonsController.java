package com.michael.claseu2.controllers;

import com.michael.claseu2.entities.PokemonsEntity;
import com.michael.claseu2.services.PokemonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PokemonsController {

    @Autowired
    PokemonsService pokemonsService;

    @GetMapping("/pokemons")
    public List<PokemonsEntity> getPokemons() {
        return pokemonsService.getPokemons();
    }

    @GetMapping("/pokemons/{id}")
    public Optional<PokemonsEntity> getByIdpokemons(@PathVariable String id) {
        return pokemonsService.getPokemons(id);
    }

    @PostMapping("/pokemons")
    public PokemonsEntity createpokemons(@RequestBody PokemonsEntity pokemons) {
        return pokemonsService.setPokemons(pokemons);
    }

    @PutMapping("/pokemons/{id}")
    public PokemonsEntity updatePokemons(@PathVariable String id, @RequestBody PokemonsEntity pokemons) {
        return pokemonsService.updatePokemons(id, pokemons);
    }

    @DeleteMapping("/pokemons/{id}")
    public Boolean deletePokemons(@PathVariable String id) {
        return pokemonsService.deletePokemons(id);
    }
}
