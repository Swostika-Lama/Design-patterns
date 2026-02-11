package State_GameCharacterDevSystem.Character;

import State_GameCharacterDevSystem.State.GameCharacterState;
import State_GameCharacterDevSystem.concreteState.NoviceState;

public class GameCharacter {
    private  final String name;
    private int experience;
    private int health;
    private GameCharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState(); // starting level
    }

    public void setState(GameCharacterState state) {
        this.state = state;
    }

    public GameCharacterState getState() {
        return state;
    }

    public void addExperience(int xp) {
        this.experience += xp;
    }

    public void addHealth(int hp) {
        this.health = Math.min(100, this.health + hp);
    }

    public void reduceHealth(int hp) {
        this.health = Math.max(0, this.health - hp);
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public void printStatus() {
        System.out.println("\n=== CHARACTER STATUS OF SYSTEM ===");
        System.out.println("Name: " + name);
        System.out.println("Level: " + state.getName());
        System.out.println("XP: " + experience);
        System.out.println("HP: " + health);
        System.out.println("========================");
    }

    // Delegated actions
    public void train() { state.train(this); }
    public void meditate() { state.meditate(this); }
    public void fight() { state.fight(this); }
}
