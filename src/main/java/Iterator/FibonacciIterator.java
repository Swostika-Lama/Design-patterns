package Iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {
    private int prev = 0;
    private int curr = 1;

    @Override
    public boolean hasNext() {
        return true; // Fibonacci sequence is infinite
    }
    @Override
    public Integer next() {
        int nextValue = prev;
        int newCurr = prev + curr;
        prev = curr;
        curr = newCurr;
        return nextValue;
    }
}
