package com.greenfoxacademy.devwars.models.characterlogic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String name;
    private int age;
    private String os;

    @OneToOne(cascade = CascadeType.ALL)
    private League league;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Competence> competenceList = new HashSet<>();
}