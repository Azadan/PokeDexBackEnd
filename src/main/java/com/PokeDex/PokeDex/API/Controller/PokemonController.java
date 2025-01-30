package com.PokeDex.PokeDex.API.Controller;



import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PokeDex.PokeDex.API.Model.Pokemon;
import com.PokeDex.PokeDex.Service.PokemonService;




@RestController
@RequestMapping("/api/pokedex")
@CrossOrigin(origins = "http://127.0.0.1:5500/HTML")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/{id}")
    public Optional<Pokemon> getPokemonById(@PathVariable Long id) {
        return pokemonService.getPokemonById(id);
    }
    
    @PostMapping
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.savePokemon(pokemon);
    }

    @DeleteMapping("/{id}")
    public List<Pokemon> deletePokemonById(@PathVariable Long id) {
        return pokemonService.deletePokemon(id);
    }

    @PutMapping("/{id}/comments")
    public Pokemon updatePokemonComment(@PathVariable Long id, @RequestBody String comment) {
        return pokemonService.updatePokemonComment(id, comment)
            .orElseThrow(() -> new RuntimeException("Pokemon ej hittad"));
    }
    
}
