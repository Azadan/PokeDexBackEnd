package com.PokeDex.PokeDex.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.PokeDex.PokeDex.API.Model.Pokemon;
import com.PokeDex.PokeDex.Repository.PokemonRepository;


/**
 * Service-klass för hantering av logik.
 * Denna klass fungerar som en mellannivå mellan controller och repository,
 * och hanterar all Pokemon-relaterad logik
 */

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    
    /**
     * Hämtar alla Pokemon från databasen.
     * @return Lista med alla tillgängliga Pokemon
     */
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    /**
     * Hämtar en specifik Pokemon baserat på ID.
     * @param id ID för Pokemon som ska hämtas
     * @return Optional innehållande Pokemon om den hittas
     */
    public Optional<Pokemon> getPokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    /**
     * Sparar en ny Pokemon.
     * @param pokemon Pokemon-objektet som ska sparas
     * @return Den sparade Pokemon med ett ID
     */
    public Pokemon savePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    /**
     * Tar bort en Pokemon och returnerar uppdaterad lista.
     * @param id ID för Pokemon som ska tas bort
     * @return Lista med alla kvarvarande Pokemon
     */
    public List<Pokemon> deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
        return pokemonRepository.findAll();
    }

    /**
     * Uppdaterar kommentaren för en specifik Pokemon.
     * @param id ID för Pokemon som ska uppdateras
     * @param comment Ny kommentar som ska läggas till
     * @return Optional innehållande den uppdaterade Pokemon om den hittas
     */
    public Optional<Pokemon> updatePokemonComment(Long id, String comment) {
        return pokemonRepository.findById(id)
            .map(pokemon -> {
                pokemon.setComments(comment);
                return pokemonRepository.save(pokemon);
            });
    }
}
