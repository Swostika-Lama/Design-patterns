package State_GameCharacterDevSystem.concreteState;

import State_GameCharacterDevSystem.Character.GameCharacter;
import State_GameCharacterDevSystem.State.GameCharacterState;

public class ExpertState implements GameCharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You train and gain 10 XP.");
        character.addExperience(10);

        if (character.getExperience() >= 200) {
            System.out.println("You advanced to MASTER level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You meditate and restore 15 HP.");
        character.addHealth(15);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You fight bravely! Lose 20 HP, gain 30 XP.");
        character.reduceHealth(20);
        character.addExperience(30);

        if (character.getHealth() <= 0) {
            System.out.println("You fainted! Rest to recover.");
        }

        if (character.getExperience() >= 200) {
            System.out.println("You advanced to MASTER level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public String getName() {
        return "Expert";
    }
}

