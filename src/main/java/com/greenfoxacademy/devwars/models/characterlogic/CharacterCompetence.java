package com.greenfoxacademy.devwars.models.characterlogic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Embeddable
public class CharacterCompetence {

    @org.hibernate.annotations.Parent
    private Character character;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "competence_id",
        nullable = false,
        updatable = false
    )
    private Competence competence;
}
