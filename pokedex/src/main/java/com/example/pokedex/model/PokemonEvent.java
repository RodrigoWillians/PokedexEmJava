package com.example.pokedex.model;

import lombok.Data;

@Data
public class PokemonEvent {
    private Long eventId;
    private String eventType;

    
    public PokemonEvent(Long eventId, String eventType) {
        this.eventId = eventId;
        this.eventType = eventType;
    }
}
