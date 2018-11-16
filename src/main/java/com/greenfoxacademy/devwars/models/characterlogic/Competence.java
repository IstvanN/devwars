package com.greenfoxacademy.devwars.models.characterlogic;

import com.greenfoxacademy.devwars.models.gamelogic.Action;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private CompetenceType type;

    @OneToMany(
            mappedBy = "requiredCompetence",
            fetch = FetchType.EAGER
    )
    private List<Action> includedActions = new ArrayList<>();
}
