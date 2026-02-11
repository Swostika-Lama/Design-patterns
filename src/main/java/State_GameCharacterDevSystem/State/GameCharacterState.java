package State_GameCharacterDevSystem.State;

import State_GameCharacterDevSystem.Character.GameCharacter;

public interface GameCharacterState {
    void train(GameCharacter characterState);
    void meditate(GameCharacter characterState);
    void fight(GameCharacter characterState);
    String getName();

}
