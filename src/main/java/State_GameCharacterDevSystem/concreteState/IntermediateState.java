package State_GameCharacterDevSystem.concreteState;

import State_GameCharacterDevSystem.Character.GameCharacter;
import State_GameCharacterDevSystem.State.GameCharacterState;

public class IntermediateState implements GameCharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You train and gain 15 XP.");
        character.addExperience(15);

        if (character.getExperience() >= 120) {
            System.out.println("You advanced to EXPERT level!");
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You meditate and restore 10 HP.");
        character.addHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are not skilled enough to fight yet.");
    }

    @Override
    public String getName() {
        return "Intermediate";
    }
}

