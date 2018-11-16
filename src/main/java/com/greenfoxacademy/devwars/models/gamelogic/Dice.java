package com.greenfoxacademy.devwars.models.gamelogic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.Random;

@Getter
@Setter
@Embeddable
public class Dice {
    @Transient
    static final Random rand = new Random();
    @Transient
    static final int MIN_SIDES = 1;

    @Column(
            name = "dice_sides",
            nullable = false
    )
    int sides;

    private Dice() {
    }

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return rand.nextInt((sides - MIN_SIDES) + 1) + MIN_SIDES;
    }

}
