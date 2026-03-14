package Strategy_Algorithm_Performance_Comparison;

public class Main {
    public static void main(String[] args) {

        int[] small = DataGenerator.generateRandomArray(30);
        int[] large = DataGenerator.generateRandomArray(100000);

        SortContext sorter = new SortContext();

        SortStrategy[] strategies = {
                new BubbleSort(),
                new MergeSort(),
                new QuickSort()
        };

        String[] names = {"Bubble Sort", "Merge Sort", "Quick Sort"};

        for (int i = 0; i < strategies.length; i++) {
            System.out.println("=== " + names[i] + " ===");

            sorter.setStrategy(strategies[i]);

            int[] smallCopy = small.clone();
            long start = System.nanoTime();
            sorter.sort(smallCopy);
            long end = System.nanoTime();
            System.out.println("Small array: " + (end - start) / 1_000_000.0 + " ms");

            int[] largeCopy = large.clone();
            start = System.nanoTime();
            sorter.sort(largeCopy);
            end = System.nanoTime();
            System.out.println("Large array: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println();
        }
    }
}
