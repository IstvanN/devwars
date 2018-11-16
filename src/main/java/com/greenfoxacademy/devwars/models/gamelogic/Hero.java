package com.greenfoxacademy.devwars.models.gamelogic;


import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.models.characterlogic.CharacterCompetence;
import com.greenfoxacademy.devwars.models.characterlogic.League;
import com.greenfoxacademy.devwars.models.characterlogic.OS;
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
  private String name;
  private League league;
  private int age;
  private OS os;
  private String imgSource;
  private List<CharacterCompetence> competences;

  public Hero(int maxHP, int currentHP, int iq, int maxActionPoint, int currentActionPoint, boolean activeHero, List<Action> availableActions, Character baseCharacter) {
    this.maxHP = maxHP;
    this.currentHP = currentHP;
    this.iq = iq;
    this.maxActionPoint = maxActionPoint;
    this.currentActionPoint = currentActionPoint;
    this.activeHero = activeHero;
    this.availableActions = availableActions;
    // The following fields will be taken from the base character
    this.name = baseCharacter.getName();
    this.league = baseCharacter.getLeague();
    this.age = baseCharacter.getAge();
    this.os = baseCharacter.getOs();
    this.imgSource = baseCharacter.getImgSource();
    this.competences = baseCharacter.getCompetences();
  }
}
