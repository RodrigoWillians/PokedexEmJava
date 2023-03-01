package com.example.pokedex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import com.example.pokedex.model.Pokemon;
import com.example.pokedex.repository.PokemonRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class PokedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}

	@Bean
CommandLineRunner init (ReactiveMongoOperations operations, PokemonRepository repository) {
return args -> {
	Flux<Pokemon> pokemonFlux = Flux.just(
		new Pokemon(null, "Blastoise", "Agua", "Torrente", 9.0),
		new Pokemon (null, "Caterpie", "Grama", "Poeira", 2.08),
		new Pokemon (null, "Bulbassauro", "Semente", "Grandeza", 10.00))
			.flatMap(repository::save);
		
pokemonFlux
	.thenMany(repository.findAll())
			.subscribe(System.out::println);
};
}
}
