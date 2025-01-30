package com.PokeDex.PokeDex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PokeDex.PokeDex.API.Model.Pokemon;
import java.util.List;


public interface PokemonRepository extends JpaRepository<Pokemon,Long>{
    //List<Pokemon> findById(long id);
}