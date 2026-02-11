package State_GameCharacterDevSystem;

import State_GameCharacterDevSystem.Character.GameCharacter;
import State_GameCharacterDevSystem.concreteState.MasterState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameCharacter hero = new GameCharacter("Sure");

        while (!(hero.getState() instanceof MasterState)) {
            hero.printStatus();

            System.out.println("Available actions (Choose 1, 2 or 3):");
            System.out.println("1. Train");
            System.out.println("2. Meditate");
            System.out.println("3. Fight");
            System.out.print("Choose action: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> hero.train();
                case 2 -> hero.meditate();
                case 3 -> hero.fight();
                default -> System.out.println("Invalid choice.");
            }
        }

        System.out.println("Congratulations! You reached MASTER level. Game over.");
    }
}

