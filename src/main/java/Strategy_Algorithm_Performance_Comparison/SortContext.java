package Strategy_Algorithm_Performance_Comparison;

public class SortContext {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    public void sort(int[] arr) {
        strategy.sort(arr);
    }
}
