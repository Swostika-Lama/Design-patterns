package Iterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence{
    @Override
    public Iterator<Integer> iterator() {
        //return an iterator that generates the fibonacci sequence
        return new FibonacciIterator();
    }
}
