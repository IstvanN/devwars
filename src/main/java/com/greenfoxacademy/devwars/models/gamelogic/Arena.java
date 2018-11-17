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

    boolean gameOver;

    @Transient
    Hero currentHero;

    Dice dice;

    protected Arena() {
    }

    protected Arena(int diceSides) {
        dice = new Dice(diceSides);
        currentTurnNumber = 0;
        nextActionLogNumber = 1;
        gameOver = false;
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

    public void executeEndTurnWithSingleAction(HeroAction heroAction) {
        executeEndTurn(Arrays.asList(heroAction));
    }

    public void executeEndTurn(List<HeroAction> heroActions) {
        if (gameOver)
            return;

        executeHeroActions(getCurrentHero(), heroActions);
        checkForGameEnd();
        if (!gameOver)
            startNextTurn();
    }

    private void checkForGameEnd() {
        for (Hero hero : heroes) {
            if (hero.getCurrentHP() <= 0)
                gameOverFor(hero);
        }
    }

    private void gameOverFor(Hero hero) {
        StringBuilder sb = new StringBuilder();
        sb.append("*** GAME OVER ***");
        sb.append(System.lineSeparator());
        sb.append(hero.getBaseCharacter().getName());
        sb.append(" has totally lost!");
        sb.append(System.lineSeparator());
        sb.append("THIS GAME WILL NOW BE DELETED");

        addActionLogMessage(sb.toString());

        gameOver = true;
    }

    public Hero getCurrentHero() {
        if (this.currentHero == null)
            this.currentHero = heroes.get(currentHeroIndex);

        return this.currentHero;
    }

    private void executeHeroActions(Hero sourceHero, List<HeroAction> heroActions) {
        // The target hero is assumed to be the next hero in turn
        Hero nextHero = heroes.get(getNextHeroIndex());

        for (HeroAction heroAction : heroActions) {
            executeHeroAction(sourceHero, heroAction, nextHero);
        }
    }

    private void executeHeroAction(
                                Hero sourceHero,
                                HeroAction heroAction,
                                Hero nextHero) {
        ActionType actionType = heroAction.getActionType();

        Hero targetHero;
        switch (actionType) {
            case DAMAGE:
                targetHero = nextHero;
                doDamageTargetHero(sourceHero, heroAction, targetHero);
                break;
            case HEAL:
                targetHero = sourceHero;
                doHealTargetHero(sourceHero, heroAction, targetHero);
                break;
            default:
                throw new IllegalArgumentException("Unknown ActionType " + actionType);
        }
    }

    private void doDamageTargetHero(
                                Hero sourceHero,
                                HeroAction heroAction,
                                Hero targetHero)
    {
        int totalDamage = -1 * calculateActionAmountTotal(sourceHero, heroAction);

        targetHero.changeCurrentHP(totalDamage);

        StringBuilder sb = new StringBuilder();
        sb.append(targetHero.getBaseCharacter().getName());
        sb.append(" has taken ");
        sb.append(totalDamage);
        sb.append(" damage, caused by ");
        sb.append(heroAction.getDescription());

        addActionLogMessage(sb.toString());
    }

    private void doHealTargetHero(
                                Hero sourceHero,
                                HeroAction heroAction,
                                Hero targetHero)
    {
        int totalGain = calculateActionAmountTotal(sourceHero, heroAction);

        targetHero.changeCurrentHP(totalGain);

        StringBuilder sb = new StringBuilder();
        sb.append(targetHero.getBaseCharacter().getName());
        sb.append(" has received ");
        sb.append(totalGain);
        sb.append(" health, caused by ");
        sb.append(heroAction.getDescription());

        addActionLogMessage(sb.toString());
    }

    private int calculateActionAmountTotal(Hero sourceHero, HeroAction heroAction) {
        int baseAmount = heroAction.getBaseAmount();
        int diceResult = rollDice();
        int amountModifier = sourceHero.getIq();

        return baseAmount + diceResult + amountModifier;
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
