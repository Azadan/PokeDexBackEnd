package com.PokeDex.PokeDex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PokeDex.PokeDex.API.Model.Pokemon;

/**
 * Repository för Pokemon-entiteter.
 * CRUD-funktionalitet (Create, Read, Update, Delete) för Pokemon.
 */
public interface PokemonRepository extends JpaRepository<Pokemon,Long>{

}