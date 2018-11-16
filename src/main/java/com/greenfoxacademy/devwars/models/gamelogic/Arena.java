package com.greenfoxacademy.devwars.models.gamelogic;

import lombok.Getter;
import lombok.Setter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
public class Arena {
    static final int DEFAULT_DICE_SIDES = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ElementCollection
    @CollectionTable(name = "arena_hero")
    @MapKeyColumn(name = "hero_order")
    Map<Integer, Hero> heroes = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "arena_action_log")
    @MapKeyColumn(name = "action_order")
    Map<Integer, String> actionLog = new HashMap<>();

    int currentTurnNumber;
    int nextActionLogNumber;

    Dice dice;

    protected Arena() {}

    protected Arena(int diceSides) {
        dice = new Dice(diceSides);
        currentTurnNumber = 1;
        nextActionLogNumber = 1;
    }

    public static Arena fromCharacters(List<Character> characters) {
        Arena newArena = new Arena(DEFAULT_DICE_SIDES);
        addHeroesFromCharacters();
        return newArena;
    }

    public int rollDice() {
        return dice.roll();
    }

    public void addActionLogMessage(String message) {
        actionLog.put(nextActionLogNumber, message);
        nextActionLogNumber++;
    }

    private static void addHeroesFromCharacters() {
        //TODO rendomly order heroes in the heroes map
        throw new NotImplementedException();
    }

}
