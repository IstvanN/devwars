package com.greenfoxacademy.devwars.models.gamelogic;


import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.models.characterlogic.CharacterCompetence;
import com.greenfoxacademy.devwars.models.characterlogic.League;
import com.greenfoxacademy.devwars.models.characterlogic.OS;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
  private int maxActionPoint;
  private int currentActionPoint;
  private boolean activeHero;

  @ManyToOne
  private Arena arena;

  @ElementCollection
  @CollectionTable(
          name = "hero_action",
          joinColumns = @JoinColumn(name = "hero_id")
  )
  private List<HeroAction> availableActions;

  @ManyToOne(fetch = FetchType.EAGER)
  private Character baseCharacter;

  public Hero(int maxHP, int currentHP, int iq, int maxActionPoint, int currentActionPoint, boolean activeHero, List<HeroAction> availableActions, Character baseCharacter) {
    this.maxHP = maxHP;
    this.currentHP = currentHP;
    this.iq = iq;
    this.maxActionPoint = maxActionPoint;
    this.currentActionPoint = currentActionPoint;
    this.activeHero = activeHero;
    this.availableActions = availableActions;
    this.baseCharacter = baseCharacter;
  }
}
