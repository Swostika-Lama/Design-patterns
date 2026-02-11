package State_GameCharacterDevSystem.concreteState;

import State_GameCharacterDevSystem.Character.GameCharacter;
import State_GameCharacterDevSystem.State.GameCharacterState;

public class NoviceState implements GameCharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You train hard and gain 20 XP.");
        character.addExperience(20);

        if (character.getExperience() >= 50) {
            System.out.println("You advanced to INTERMEDIATE level!");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You cannot meditate at Novice level.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are too weak to fight at Novice level.");
    }

    @Override
    public String getName() {
        return "Novice";
    }
}
