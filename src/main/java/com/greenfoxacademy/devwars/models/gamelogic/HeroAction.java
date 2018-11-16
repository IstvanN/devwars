package com.greenfoxacademy.devwars.models.gamelogic;

import javax.persistence.Embeddable;

@Embeddable
public class HeroAction {

    private ActionType actionType;
    private String name;
    private String description;
    private int baseAmount;

}
