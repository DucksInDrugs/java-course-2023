package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final Iterator<T> backwardIterator;

    public BackwardIterator(List<T> backwardIterator) {
        List<T> reversedList = new ArrayList<>();
        for (int i = backwardIterator.size() - 1; i >= 0; i--) {
            reversedList.add(backwardIterator.get(i));
        }
        this.backwardIterator = reversedList.iterator();
    }

    @Override
    public boolean hasNext() {
        return backwardIterator.hasNext();
    }

    @Override
    public T next() {
        return backwardIterator.next();
    }
}
