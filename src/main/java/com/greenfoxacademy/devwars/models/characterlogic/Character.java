package com.greenfoxacademy.devwars.models.characterlogic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "game_character")
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
            case BACKEND:
                imgSource = "/images/backend.jpg";
            case DEVOPS:
                imgSource = "/images/devops.jpg";
            case FRONTEND:
                imgSource = "/images/frontend.jpg";
            case TESTER:
                imgSource = "/images/tester.jpg";
            case EMBEDDED:
                imgSource = "/images/embedded.jpg";
            case DATA_SCIENTIST:
                imgSource = "/images/ds.jpg";
            default:
                imgSource = "/images/moth.jpg";
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

    public void addCompetence(Competence competence) {
        CharacterCompetence characterCompetence = new CharacterCompetence(competence);
        competences.add(characterCompetence);
    }

    public void setLeague(League league) {
        this.league = league;
        switch (league) {
            case BACKEND:
                imgSource = "/images/backend.jpg";
                break;
            case DEVOPS:
                imgSource = "/images/devops.jpg";
                break;
            case FRONTEND:
                imgSource = "/images/frontend.jpg";
                break;
            case TESTER:
                imgSource = "/images/tester.jpg";
                break;
            case EMBEDDED:
                imgSource = "/images/embedded.jpg";
                break;
            case DATA_SCIENTIST:
                imgSource = "/images/ds.jpg";
                break;
        }
    }
}