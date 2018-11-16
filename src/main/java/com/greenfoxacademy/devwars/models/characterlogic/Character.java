package com.greenfoxacademy.devwars.models.characterlogic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "game_character")
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String name;
    private int age;

    @OneToOne
    private OS os;

    private League league;

    private String imgSource;

    @ElementCollection
    @CollectionTable(
        name = "game_character_competence",
        joinColumns = @JoinColumn(name = "character_id")
    )
    private List<CharacterCompetence> competences = new ArrayList<>();

    public Character(String name, int age, String os, League league) {
        this.name = name;
        this.age = age;
        this.os = new OS(os);
        this.league = league;
        switch (league) {
            default: imgSource = "image.jpg";
        }
    }

    @Override
    public String toString() {
        return "Character {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", os=" + os +
                ", league=" + league +
                '}';
    }
}