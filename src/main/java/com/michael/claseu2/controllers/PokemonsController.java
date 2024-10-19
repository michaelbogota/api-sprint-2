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
    PokemonsService PokemonsService;

    @GetMapping("/pokemons")
    public List<PokemonsEntity> getPokemons() {
        return PokemonsService.getPokemons();
    }

    @GetMapping("/pokemons/{id}")
    public Optional<PokemonsEntity> getByIdpokemons(@PathVariable String id) {
        return PokemonsService.getPokemons(id);
    }

    @PostMapping("/pokemons")
    public Boolean createpokemons(@RequestBody PokemonsEntity pokemons) {
        return PokemonsService.setPokemons(pokemons);
    }

    @PutMapping("/pokemons/{id}")
    public Boolean updatePokemons(@PathVariable String id, @RequestBody PokemonsEntity pokemons) {
        return PokemonsService.updatePokemons(id, pokemons);
    }

    @DeleteMapping("/pokemons/{id}")
    public Boolean deletePokemons(@PathVariable String id) {
        return PokemonsService.deletePokemons(id);
    }
}
