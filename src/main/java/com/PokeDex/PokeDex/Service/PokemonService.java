package com.PokeDex.PokeDex.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.PokeDex.PokeDex.API.Model.Pokemon;
import com.PokeDex.PokeDex.Repository.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon savePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public List<Pokemon> deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> updatePokemonComment(Long id, String comment) {
        return pokemonRepository.findById(id)
            .map(pokemon -> {
                pokemon.setComments(comment);
                return pokemonRepository.save(pokemon);
            });
    }
}
