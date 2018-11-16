package com.greenfoxacademy.devwars.models.gamelogic;


import com.greenfoxacademy.devwars.models.characterlogic.*;
import com.greenfoxacademy.devwars.models.characterlogic.Character;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Hero {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private int maxHP;
  private int currentHP;
  private int iq;
  private int maxActionPoints;
  private int currentActionPoints;
  private int actionPointsPerTurn;
  private Boolean active;

  @ManyToOne
  private Arena arena;

  @ElementCollection
  @CollectionTable(
          name = "hero_action",
          joinColumns = @JoinColumn(name = "hero_id")
  )
  private List<HeroAction> availableActions = new ArrayList<>();

  @ManyToOne(
          fetch = FetchType.EAGER
  )
  private Character baseCharacter;

  public Hero(int maxHP, int currentHP, int iq, int maxActionPoints, int currentActionPoints, int actionPointsPerTurn, Character baseCharacter) {
    this.maxHP = maxHP;
    this.currentHP = currentHP;
    this.iq = iq;
    this.maxActionPoints = maxActionPoints;
    this.currentActionPoints = currentActionPoints;
    this.actionPointsPerTurn = actionPointsPerTurn;
    this.baseCharacter = baseCharacter;

    this.availableActions = createAvailableActions();
  }

  private List<HeroAction> createAvailableActions() {
    List<HeroAction> heroActions = new ArrayList<>();

    List<Action> characterActions;
    List<CharacterCompetence> baseCharacterCompetences = getBaseCharacter().getCompetences();
    for (CharacterCompetence competence : baseCharacterCompetences) {
      characterActions = competence.getCompetence().getIncludedActions();
      for (Action action : characterActions) {
        heroActions.add(HeroAction.fromAction(action));
      }
    }

    return heroActions;
  }

  @Override
  public String toString() {
    return "Hero: " + baseCharacter;
  }
}
