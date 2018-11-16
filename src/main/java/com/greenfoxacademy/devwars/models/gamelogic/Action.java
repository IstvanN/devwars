package com.greenfoxacademy.devwars.models.gamelogic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Action {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private ActionType actionType;
  private String name;
  private String description;
  private int baseAmount;

  public Action(String name, int baseAmount, ActionType actionType, String description) {
    this.name = name;
    this.baseAmount = baseAmount;
    this.actionType = actionType;
    this.description = description;
  }
}
