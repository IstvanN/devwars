package com.greenfoxacademy.devwars.models.gamelogic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable
public class HeroAction {

    private ActionType actionType;
    private String name;
    private String description;
    private int baseAmount;

    private HeroAction() {

    }

    public static HeroAction fromAction(Action action) {
        HeroAction newHeroAction = new HeroAction();

        newHeroAction.setActionType(action.getActionType());
        newHeroAction.setBaseAmount(action.getBaseAmount());
        newHeroAction.setDescription(action.getDescription());
        newHeroAction.setName(action.getName());

        return newHeroAction;
    }

}
