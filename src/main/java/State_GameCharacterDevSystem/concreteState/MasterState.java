package State_GameCharacterDevSystem.concreteState;

import State_GameCharacterDevSystem.Character.GameCharacter;
import State_GameCharacterDevSystem.State.GameCharacterState;

public class MasterState implements GameCharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You are a Master. Training is no longer needed.");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You are a Master. Meditation is optional.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are a Master. There is nothing left to prove.");
    }

    @Override
    public String getName() {
        return "Master";
    }
}

