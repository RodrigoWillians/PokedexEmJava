package com.example.pokedex.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.pokedex.model.Pokemon;

public interface PokemonRepository extends ReactiveMongoRepository <Pokemon, String>{
    
}
