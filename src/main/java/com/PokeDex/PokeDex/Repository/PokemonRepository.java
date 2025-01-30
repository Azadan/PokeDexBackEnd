package com.PokeDex.PokeDex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PokeDex.PokeDex.API.Model.Pokemon;


public interface PokemonRepository extends JpaRepository<Pokemon,Long>{

}