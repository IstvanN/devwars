package com.greenfoxacademy.devwars.models.gamelogic;


import com.greenfoxacademy.devwars.models.characterlogic.League;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Hero {

  private int maxHP;
  private int currentHP;
  private int iq;
  private int maxActionPoint;
  private int currentActionPoint;
  boolean activeHero;
  private List<Action> availableActions;
  // The following fields will be taken from the base character
  private League league;
  private int age;

  public Hero(int maxHP, int currentHP, int iq, int maxActionPoint, int currentActionPoint, boolean activeHero, List<Action> availableActions, League league, int age) {
    this.maxHP = maxHP;
    this.currentHP = currentHP;
    this.iq = iq;
    this.maxActionPoint = maxActionPoint;
    this.currentActionPoint = currentActionPoint;
    this.activeHero = activeHero;
    this.availableActions = availableActions;
    this.league = league;
    this.age = age;
  }
}
