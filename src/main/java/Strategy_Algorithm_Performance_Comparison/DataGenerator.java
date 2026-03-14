package Strategy_Algorithm_Performance_Comparison;

import java.util.Random;

public class DataGenerator {
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1_000_000);
        }
        return arr;
    }
}

