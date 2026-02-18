package Template_Applying_GameFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakeAndLadders extends Game {
    private int numberOfPlayers;
    private int[] positions;
    private Map<Integer, Integer> jumps; // snakes + ladders
    private Random random;
    private int winner = -1;
    private final int WINNING_SQUARE = 100;

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.positions = new int[numberOfPlayers];
        this.random = new Random();

        // Define snakes and ladders
        jumps = new HashMap<>();
        // ladders
        jumps.put(4, 14);
        jumps.put(9, 31);
        jumps.put(20, 38);
        // snakes
        jumps.put(17, 7);
        jumps.put(54, 34);
        jumps.put(62, 19);
        jumps.put(87, 24);

        System.out.println("Snakes & Ladders game starting with " + numberOfPlayers + " players.");
        System.out.println("First to reach square " + WINNING_SQUARE + " wins.");
        System.out.println("----------------------------------------------------------------------");
    }

    @Override
    public boolean endOfGame() {
        return winner != -1;
    }

    @Override
    public void playSingleTurn(int player) {
        int roll = random.nextInt(6) + 1;
        System.out.println("Player " + player + " rolls a " + roll);

        int newPos = positions[player] + roll;

        if (newPos > WINNING_SQUARE) {
            System.out.println("Roll too high, player stays at " + positions[player]);
            return;
        }

        System.out.println("Player " + player + " moves from " + positions[player] + " to " + newPos);

        // Check for snake or ladder
        if (jumps.containsKey(newPos)) {
            int finalPos = jumps.get(newPos);
            if (finalPos > newPos) {
                System.out.println("Ladder! Climb up to " + finalPos);
            } else {
                System.out.println("Snake! Slide down to " + finalPos);
            }
            newPos = finalPos;
        }

        positions[player] = newPos;

        if (newPos == WINNING_SQUARE) {
            winner = player;
        }
    }

    @Override
    public void displayWinner() {
        System.out.println("Player " + winner + " wins the game!");
    }
}

