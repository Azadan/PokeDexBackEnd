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
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PokemonController {

    private final PokemonService pokemonService;
   
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    /**
     * Hämtar alla Pokemon från databasen.
     * @return En lista med alla Pokemon
     */
    @GetMapping
    public List<Pokemon> getAllPokemons() {
        return pokemonService.getAllPokemon();
    }

    /**
     * Hämtar en Pokemon baserat på ID.
     * @param id Pokemon-ID som ska hämtas
     * @return Optional med Pokemon om den hittas
     */
    @GetMapping("/{id}")
    public Optional<Pokemon> getPokemonById(@PathVariable Long id) {
        return pokemonService.getPokemonById(id);
    }
    
    /**
     * Lägger till en ny Pokemon i databasen.
     * @param pokemon Pokemon-objektet som ska sparas
     * @return Den sparade Pokemon med tilldelat ID
     */
    @PostMapping("/add")
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
        // debug sysout för att se om den tar emot någon pokemon
        System.out.println("Fångad pokemon: " + pokemon);
        return pokemonService.savePokemon(pokemon);
    }

     /**
     * Tar bort en Pokemon baserat på ID.
     * @param id Pokemon-ID som ska tas bort
     * @return Uppdaterad lista med alla kvarvarande Pokemon
     */
    @DeleteMapping("/{id}")
    public List<Pokemon> deletePokemonById(@PathVariable Long id) {
        return pokemonService.deletePokemon(id);
    }

    /**
     * Uppdaterar kommentaren för en specifik Pokemon.
     * @param id Pokemon-ID vars kommentar ska uppdateras
     * @param comment Ny kommentar som ska läggas till
     * @return Uppdaterad Pokemon med samma id och ny kommentar
     * @throws RuntimeException om Pokemon inte hittas
     */
    @PutMapping("/{id}/comments")
    public Pokemon updatePokemonComment(@PathVariable Long id, @RequestBody String comment) {
        return pokemonService.updatePokemonComment(id, comment)
            .orElseThrow(() -> new RuntimeException("Pokemon ej hittad"));
    }
    
}
