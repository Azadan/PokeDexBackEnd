package com.PokeDex.PokeDex.API.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Pokemon-entitet-
 * Innehåller all grundläggande information om en Pokemon,
 * Konstruktörer samt getters/setter är skapade med lombok annotation
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "image", nullable = false)
    @Getter
    @Setter
    private String imageURL;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String name;
    
    @Column(name = "type", nullable = false)
    @Getter
    @Setter
    private String type;

    @Column(name = "base_experience", nullable = false)
    @Getter
    @Setter
    private int baseExperience;

    @Column(name = "health", nullable = false)
    @Getter
    @Setter
    private int health;

    @Column(name = "attack", nullable = false)
    @Getter
    @Setter
    private int attack;
    
    @Column(name = "defence", nullable = false)
    @Getter
    @Setter
    private int defence;

    @Column(name = "special_attack", nullable = false)
    @Getter
    @Setter
    private int specialAttack;

    @Column(name = "special_defence", nullable = false)
    @Getter
    @Setter
    private int specialDefence;

    @Column(name = "speed", nullable = false)
    @Getter
    @Setter
    private int speed;

    @Column(name = "comments", nullable = true)
    @Getter
    @Setter
    private String comments;

}