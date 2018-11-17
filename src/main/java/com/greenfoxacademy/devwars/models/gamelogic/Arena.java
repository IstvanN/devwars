package com.greenfoxacademy.devwars.models.gamelogic;

import lombok.Getter;
import lombok.Setter;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
public class Arena {
    private static final Random rand = new Random();

    private static final int DEFAULT_DICE_SIDES = 6;

    private static final int DEFAULT_HERO_STARTING_HP = 50;
    private static final int DEFAULT_HERO_MAX_HP = 50;
    private static final int DEFAULT_HERO_MAX_AP = 10;
    private static final int DEFAULT_HERO_STARTING_AP = 0;
    private static final int DEFAULT_HERO_IQ = 5;
    private static final int DEFAULT_HERO_AP_PER_TURN = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(
            mappedBy = "arena",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    List<Hero> heroes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "arena_action_log")
    @MapKeyColumn(name = "action_order")
    @Column(
            name = "message",
            length = 1000
    )
    Map<Integer, String> actionLog = new HashMap<>();
    int nextActionLogNumber;

    int currentTurnNumber;
    int currentHeroIndex;

    @Transient
    Hero currentHero;

    Dice dice;

    protected Arena() {
    }

    protected Arena(int diceSides) {
        dice = new Dice(diceSides);
        currentTurnNumber = 0;
        nextActionLogNumber = 1;
    }

    public Arena(List<Character> characters) {
        this(DEFAULT_DICE_SIDES);
        setHeroes(getHeroesFromCharacters(characters));
        addActionLogMessage("Starting battle between these heroes: " + this.getHeroes());
        startNextTurn();
    }

    public int rollDice() {
        return dice.roll();
    }

    public void addActionLogMessage(String message) {
        actionLog.put(nextActionLogNumber, message);
        nextActionLogNumber++;
    }

    public void executeEndTurn(List<HeroAction> heroActions) {
        executeHeroActions(getCurrentHero(), heroActions);
        startNextTurn();
    }

    public Hero getCurrentHero() {
        if (this.currentHero == null)
            this.currentHero = heroes.get(currentHeroIndex);

        return this.currentHero;
    }

    private void executeHeroActions(Hero sourceHero, List<HeroAction> heroActions) {
        // The target hero is assumed to be the next hero in turn
        Hero targetHero = heroes.get(getNextHeroIndex());

        for (HeroAction heroAction : heroActions) {
            addActionLogMessage("TODO Not really executing, but would be: " + heroAction);
        }
    }

    private void startNextTurn() {
        currentTurnNumber++;
        switchToNextHero();
        addActionLogMessage("Starting new turn " +
                currentTurnNumber + " for " + getCurrentHero());
        replenishCurrentHeroActionPoints();
    }

    private void switchToNextHero() {
        getCurrentHero().setActive(false);
        currentHeroIndex = getNextHeroIndex();
        currentHero = heroes.get(currentHeroIndex);
        currentHero.setActive(true);
    }

    private int getNextHeroIndex() {
        if (currentHeroIndex == heroes.size() - 1)
            return 0;
        else
            return currentHeroIndex + 1;
    }

    private void replenishCurrentHeroActionPoints() {
        getCurrentHero().changeCurrentActionPoints(DEFAULT_HERO_AP_PER_TURN);
    }

    private List<Hero> getHeroesFromCharacters(List<Character> characters) {
        List<Hero> heroes = new ArrayList<>();

        for (Character character : characters) {
            int iqModifier = character.getOs().getIQmodifier();

            Hero newHero = new Hero(
                    this,
                    DEFAULT_HERO_MAX_HP,
                    DEFAULT_HERO_STARTING_HP,
                    DEFAULT_HERO_IQ + iqModifier,
                    DEFAULT_HERO_MAX_AP,
                    DEFAULT_HERO_STARTING_AP,
                    DEFAULT_HERO_AP_PER_TURN,
                    character
            );

            heroes.add(newHero);
        }

        setRandomHeroOrder(heroes);
        return heroes;
    }

    private void setRandomHeroOrder(List<Hero> heroes) {
        int heroCount = heroes.size();
        int randomIndex = rand.nextInt(heroCount);

        // TODO really we should randomly re-order the heroes, but we just select a random starter
        Hero oneHero;
        for (int i = 0; i < heroCount; i++) {
            oneHero = heroes.get(i);
            if (i == randomIndex) {
                this.currentHeroIndex = i;
                this.currentHero = oneHero;
                this.currentHero.setActive(true);
            } else {
                oneHero.setActive(false);
            }
        }
    }
}
